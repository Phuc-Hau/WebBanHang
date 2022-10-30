package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.OrderDetailDao;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailDao OrderDetailDao;


    @Override
    public List<OrderDetail> findAll() {
        return OrderDetailDao.findAll();
    }

    @Override
    public OrderDetail findById(Integer id) {
        return OrderDetailDao.findById(id).get();
    }

    @Override
    public OrderDetail create(OrderDetail entity) {
        return OrderDetailDao.save(entity);
    }

    @Override
    public OrderDetail update(OrderDetail entity) {
        return OrderDetailDao.save(entity);
    }

    @Override
    public void delete(OrderDetail entity) {
        OrderDetailDao.delete(entity);
    }

    @Override
    public List<OrderDetail> findAllUsername(int id) {
        return OrderDetailDao.findAllUsername(id);
    }

    @Override
    public OrderDetail findIdProduct(int idProduct, int idCutomer) {
        return OrderDetailDao.findIdProduct(idProduct,idCutomer);
    }

    @Override
    public boolean existsById(Integer id) {
        return OrderDetailDao.existsById(id);
    }
}
