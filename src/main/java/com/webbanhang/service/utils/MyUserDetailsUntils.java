package com.webbanhang.service.utils;

import com.webbanhang.jpa.dao.CutomerDao;
import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.Users;
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
    UserDao userDao;

    @Autowired
    CutomerDao cutomerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Users users = userDao.findByUsername(username);

            BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
            return User.withUsername(users.getUsername())
                    .password(pe.encode(users.getPassword()))
                    .authorities(users.getRole())
                    .build();
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

        Users users = userDao.findByEmailAndTokeID(email,nameID);

        if(users != null){
            userDetails = User.withUsername(users.getUsername())
                    .password(pe.encode(users.getPassword()))
                    .authorities(users.getRole()).build();
        }else{
            Cutomer cutomer = new Cutomer();
            Users user = userDao.findByEmail(email);

            if(user == null) {

                cutomer.setName(fullname);
                cutomerDao.save(cutomer);

                user = new Users();
                user.setUsername(nameID);
                user.setEmail(email);
                user.setCutomer(cutomer);
                user.setToken(nameID);

                userDao.save(user);

            }else{
                user.setToken(nameID);
                userDao.save(user);
            }

            userDetails = User.withUsername(user.getUsername())
                    .password(pe.encode(user.getPassword()))
                    .authorities(user.getRole()).build();

        }

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

    }
}
