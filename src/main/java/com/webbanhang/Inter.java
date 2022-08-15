package com.webbanhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Inter implements WebMvcConfigurer {

    @Autowired
    Handle handle;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handle).addPathPatterns("/**");
    }
}
