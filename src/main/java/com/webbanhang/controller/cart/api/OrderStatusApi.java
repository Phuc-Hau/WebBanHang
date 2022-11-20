package com.webbanhang.controller.cart.api;


import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.OrderStatus;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.OrderService;
import com.webbanhang.jpa.service.OrderStatusService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Order> cart(HttpServletRequest request) {
        String username = request.getRemoteUser();

        Users user =userService.findByUsername(username);

        List<Order> list = orderService.findAllOrderStatus(user.getCutomer().getId());

        return list;
    }

    @PostMapping("/listordersDetailStatus/{idOrder}")
    public List<OrderDetail> detail(HttpServletRequest request,@PathVariable("idOrder") int idOrder) {
        String username = request.getRemoteUser();

        Users user =userService.findByUsername(username);

        List<OrderDetail> list = orderDetailService.findAllOrderStatust(user.getCutomer().getId(),idOrder);

        return list;
    }

    @PostMapping("/listordersDetail")
    public List<OrderDetail> listordersDetail(HttpServletRequest request) {
        String username = request.getRemoteUser();

        Users user =userService.findByUsername(username);

        List<OrderDetail> list = orderDetailService.findAllOrderUsername(user.getCutomer().getId());

        return list;
    }



    @GetMapping("OrderStatus")
    public List<OrderStatus> status(){
        return orderStatusService.findAll();
    }



}
