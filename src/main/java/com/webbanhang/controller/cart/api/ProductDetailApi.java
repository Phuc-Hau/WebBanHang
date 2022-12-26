package com.webbanhang.controller.cart.api;

import com.webbanhang.jpa.dao.OrderDetailDao;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.ProductService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class ProductDetailApi {
    @Autowired
    ProductService productService;

    @Autowired
    OrderDetailService orderDetailService;


    @GetMapping("/product/{id}")
    public Product doGetFL (@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/groupproduct/{id}")
    public List<Product> getProduct( @PathVariable("id") int id){
        return productService.getProductGroup(id);
    }

    @GetMapping("/product/amountpay/{id}")
    public int getAmountPay (@PathVariable("id") int id){
        int amountpay =0;
        try {
            amountpay = orderDetailService.amountPay(id);
        } catch (Exception e){
            amountpay =0;
        }
        return amountpay;
    }

}
