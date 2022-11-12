package com.webbanhang.controller.cart.api;


import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.OrderService;
import com.webbanhang.jpa.service.OrderStatusService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts/api")
public class OrderStatusApi {

    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderService orderService;

    @Autowired
    UsersService userService;

    @GetMapping("/listorderstatus")
    public List<OrderDetail> cart(HttpServletRequest request) {

//        String username = request.getRemoteUser();
//
//        Users user =userService.findByUsername(username);

        List<OrderDetail> list = orderDetailService.findAllOrderStatust(1);

        return list;
    }


}
