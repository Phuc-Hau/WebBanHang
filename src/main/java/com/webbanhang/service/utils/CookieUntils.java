package com.webbanhang.service.utils;

import com.webbanhang.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieUntils implements CookieService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @Override
    public Cookie get(String name) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equalsIgnoreCase(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(String name) {
        Cookie cookie = get(name);
        if(cookie != null) {
            return cookie.getValue();
        }
        return null;
    }


    @Override
    public Cookie add(String name, String value, int hours) {
        Cookie  cookie = new Cookie(name, value);
        cookie.setMaxAge(hours*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }

    @Override
    public void remove(String name) {
        add(name, "", 0);
    }
}
