package com.webbanhang.controller.cart.api;


import com.webbanhang.jpa.model.*;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.OrderService;
import com.webbanhang.jpa.service.OrderStatusService;
import com.webbanhang.jpa.service.UsersService;
import net.minidev.json.JSONObject;
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

    @PostMapping("/OrderHuy/{id}")
    public JSONObject OrderHuy(@PathVariable("id") int id){
        JSONObject obj = new JSONObject();
        Order order = orderService.findById(id);
        order.setStatus(5);
        try {
            orderService.update(order);
            obj.put("status",true);
            obj.put("message", "Hủy thành công!");
        }catch (Exception e){
            obj.put("status",false);
            obj.put("message", "Hủy thất bại!");
        }
        return obj;
    }

    @GetMapping("userQuantityProduct")
    public Object userQuantityProduct(HttpServletRequest request){
        String username = request.getRemoteUser();

        Users user =userService.findByUsername(username);
        return orderDetailService.QuantityProduct(user.getCutomer().getId());
    }


}
