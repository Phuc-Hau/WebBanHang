package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.OrderDetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailService {


    List<OrderDetail> findAll();
    OrderDetail findById(Integer id);
    OrderDetail create(OrderDetail entity);
    OrderDetail update(OrderDetail entity);
    void delete(OrderDetail entity);

    List<OrderDetail> findAllUsername(int id);
    OrderDetail findIdProduct(int idProduct, int idCutomer);
    
    boolean existsById(Integer id);

}
