package com.webbanhang;

import com.webbanhang.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();

        // phan quyen
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(new String[]{"/account/cart/**","/account/newcart","/account/changinformation"}).authenticated()
                .anyRequest().permitAll();

        // fomr login
        http.formLogin().loginPage("/account/signin")
                .loginProcessingUrl("/account/login") // post url login
                .defaultSuccessUrl("/product/index",false)
                .failureUrl("/account/login/error")
                .usernameParameter("username")
                .passwordParameter("password");

        http.oauth2Login().loginPage("/account/signin")
                .defaultSuccessUrl("/account/oauth/signin",true)
                .failureUrl("/auth/login/error")
                .authorizationEndpoint()
                .baseUri("/oauth2/authorization");

        http.rememberMe().key("uniqueAndSecret");

        // logout
        http.logout().logoutUrl("/account/logoff").logoutSuccessUrl("/account/signin").deleteCookies("JSESSIONID");

        // dieu kiem loi tru cap khong dung quyen
        http.exceptionHandling().accessDeniedPage("/account/signin");
    }

    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean factoryBean() {
        FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        return bean;
    }
}
