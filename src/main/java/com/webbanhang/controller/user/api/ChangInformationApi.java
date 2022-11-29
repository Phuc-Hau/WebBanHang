package com.webbanhang.controller.user.api;

import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.UsersService;
import com.webbanhang.service.ConvenientService;
import com.webbanhang.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@CrossOrigin("*")
@RestController
@RequestMapping("/account/api")
public class ChangInformationApi {
    @Autowired
    UsersService usersService;

    @Autowired
    CutomerService cutomerService;

    @Autowired
    ConvenientService convenientUtils;

    @Autowired
    SessionService session;

    @Autowired
    OrderDetailService orderDetailService;


    @RequestMapping("/changinformation")
    public Users changInformation(HttpServletRequest request){
        String username = request.getRemoteUser();
        Users user = usersService.findByUsername(username);
        return user;
    }

}
