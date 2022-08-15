package com.webbanhang.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface MyUserDetailsService extends UserDetailsService {

    /**
     * Login trên db
     * @param username username đăng nhập
     * @return trả về user đăng nhập
     * @throws UsernameNotFoundException
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Đăng nhập bằng mạng xã hội
     * @param token thông tin tài khoản
     */
    void loginFromOAuth2(OAuth2AuthenticationToken token);
}
