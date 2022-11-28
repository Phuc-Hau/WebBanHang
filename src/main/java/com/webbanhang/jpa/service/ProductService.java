package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.Product;

import java.util.List;

public interface ProductService {


    List<Product> findAll();
    Product findById(Integer id);
    Product create(Product entity);
    Product update(Product entity);
    int getLastId();
    boolean existsById(Integer id);

    List<Product> getProductGroup(int idGroupProduct);


}
