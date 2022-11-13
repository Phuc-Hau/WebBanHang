package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    List<OrderStatus> findAll();
    OrderStatus findById(Integer id);
    OrderStatus create(OrderStatus entity);
    OrderStatus update(OrderStatus entity);

    boolean existsById(Integer id);
}
