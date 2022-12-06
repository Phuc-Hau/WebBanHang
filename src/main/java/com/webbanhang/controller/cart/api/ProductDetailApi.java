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


    @GetMapping("/product/{id}")
    public Product doGetFL (@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/groupproduct/{id}")
    public List<Product> getProduct( @PathVariable("id") int id){
        return productService.getProductGroup(id);
    }



}
