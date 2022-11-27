package com.webbanhang.controller.cart.api;

import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
public class ProductDetailApi {
    @Autowired
    ProductService productService;

    @GetMapping("/product/api/{id}")
    public Product doGetFL (@PathVariable("id") int id) {
        return productService.findById(id);
    }

}
