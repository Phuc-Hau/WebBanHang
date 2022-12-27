package com.webbanhang.service.utils;

import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.UsersService;
import com.webbanhang.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsUntils implements UserDetailsService, MyUserDetailsService {
    @Autowired
    UsersService usersService;

    @Autowired
    CutomerService cutomerServices;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            Users users = usersService.findByUsername(username);
            BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
            if(users.isStatus()){
                return User.withUsername(users.getUsername())
                        .password(pe.encode(users.getPassword()))
                        .authorities(users.getRole())
                        .build();
            }else{
                return User.withUsername(users.getUsername()).build();
            }

        }catch (Exception e){
            throw new UsernameNotFoundException(username);
        }

    }

    public void loginFromOAuth2(OAuth2AuthenticationToken token){
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

        String nameID = token.getName();
        String fullname = token.getPrincipal().getAttribute("name");
        String email = token.getPrincipal().getAttribute("email");

        UserDetails userDetails = null;

        Users users = usersService.findByEmailAndTokeID(email,nameID);

        if(users != null){
            userDetails = User.withUsername(users.getUsername())
                    .password(pe.encode(users.getPassword()))
                    .authorities(users.getRole()).build();
        }else{
            Cutomer cutomer = new Cutomer();
            Users user = usersService.findByEmail(email);

            if(user == null) {

                cutomer.setName(fullname);
                cutomerServices.create(cutomer);

                user = new Users();
                user.setUsername(nameID);
                user.setEmail(email);
                user.setCutomer(cutomer);
                user.setToken(nameID);

                usersService.create(user);

            }else{
                user.setToken(nameID);
                usersService.create(user);
            }

            userDetails = User.withUsername(user.getUsername())
                    .password(pe.encode(user.getPassword()))
                    .authorities(user.getRole()).build();

        }

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

    }
}
