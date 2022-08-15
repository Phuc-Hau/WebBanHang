package com.webbanhang;


import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Handle implements HandlerInterceptor {
    @Autowired
    UserDao userDao;

    @Autowired
    SessionService sessionService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String username =request.getRemoteUser();
        Users users = null;

        if(username != null){
            users = userDao.findByUsername(username);
        }
       sessionService.set("users",users);

    }
}
