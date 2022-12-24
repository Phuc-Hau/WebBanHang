package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.service.OrderDetailService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class StatisticalProductApi {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/StatisticalProduct")
    public List<OrderDetail> adminNewGroupProduct() {
        return orderDetailService.orderDetailPay();
    }

}
