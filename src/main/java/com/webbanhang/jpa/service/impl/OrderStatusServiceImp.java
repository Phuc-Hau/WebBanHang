package com.webbanhang.jpa.service.impl;


import com.webbanhang.jpa.dao.OrderStatusDao;
import com.webbanhang.jpa.model.OrderStatus;
import com.webbanhang.jpa.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImp implements OrderStatusService {

    @Autowired
    OrderStatusDao orderStatusDao;

    @Override
    public List<OrderStatus> findAll() {
        return orderStatusDao.findAll();
    }

    @Override 
    public OrderStatus findById(Integer id) {
        return orderStatusDao.findById(id).get();
    }

    @Override
    public OrderStatus create(OrderStatus entity) {
        return orderStatusDao.save(entity);
    }

    @Override
    public OrderStatus update(OrderStatus entity) {
        return orderStatusDao.save(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return orderStatusDao.existsById(id);
    }
}
