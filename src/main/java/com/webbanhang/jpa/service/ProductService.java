package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Product;

import java.util.List;

public interface ProductService {


    List<Product> findAll();

    List<Product> findAllStatus();
    Product findById(Integer id);
    Product create(Product entity);
    Product update(Product entity);

    Product getProductById(int idProduct);
    int getLastId();
    boolean existsById(Integer id);

    List<Product> getProductGroup(int idGroupProduct);

    void UpdateAmoutPay(List<OrderDetail> orderDetails , int x);

    List<Product> fashSale();

    List<Product> productSY();

    List<Product> productGroup(int idGroup);

    List<Product> searchKeyWord(String keyWord);

}
