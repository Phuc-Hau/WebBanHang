package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class ProductAdminApi {
    @Autowired
    ProductService productService;

    @RequestMapping("/api/product/edit/{id}")
    public Product adminEditProductList(@PathVariable("id") int id) {
        return productService.findById(id);
    }
}
