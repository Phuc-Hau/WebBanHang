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
    public List<OrderDetail> listCreate(List<OrderDetail> orderDetails) {
        return OrderDetailDao.saveAll(orderDetails);
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
    public List<OrderDetail> findAllOrderStatust(int idCutomer, int idOrder) {
        return OrderDetailDao.findAllOrderStatust(idCutomer, idOrder);
    }

    @Override
    public List<OrderDetail> findAllOrderUsername(int idCutomer) {
        return OrderDetailDao.findAllOrderUsername(idCutomer);
    }

    @Override
    public boolean existsById(Integer id) {
        return OrderDetailDao.existsById(id);
    }

    @Override
    public List<Object> QuantityProduct(int idCutomer) {
        return OrderDetailDao.QuantityProduct(idCutomer);
    }

    @Override
    public List<OrderDetail> orderDetailPay() {
        return OrderDetailDao.orderDetailPay();
    }

    @Override
    public List<OrderDetail> orderDetailPay(int idProduct) {
        return OrderDetailDao.orderDetailPay(idProduct);
    }

    @Override
    public int amountPay(int idProduct) {
        return OrderDetailDao.amountPay(idProduct);
    }
}
