package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.OrderDao;
import com.webbanhang.jpa.model.CountMonth;
import com.webbanhang.jpa.model.MoneyMonth;
import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.service.OrderService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao OrderDao;


    @Override
    public List<Order> findAll() {
        return OrderDao.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return OrderDao.findById(id).get();
    }

    @Override
    public Order create(Order entity) {
        return OrderDao.save(entity);
    }

    @Override
    public Order update(Order entity) {
        return OrderDao.save(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return OrderDao.existsById(id);
    }

    @Override
    public Order findIdCutomer(int id) {
        return OrderDao.findIdCutomer(id);
    }

    @Override
    public int sumPriceOrder(int idOrder) {
        return OrderDao.sumPriceOrder(idOrder);
    }

    @Override
    public int sumPriceMonth(int month) {
        return OrderDao.sumPriceMonth(month);
    }

    @Override
    public int sumPriceYear(int year) {
        return OrderDao.sumPriceYear(year);
    }

    @Override
    public int sumCountMonth(int month) {
        return OrderDao.sumCountMonth(month);
    }

    @Override
    public List<MoneyMonth> moneyMonthYear(int year) {
        return OrderDao.moneyMonthYear(year);
    }

    @Override
    public List<CountMonth> countMonthYear(int year) {
        return OrderDao.countMonthYear(year);
    }

    @Override
    public List<Order> findAllOrderStatus(int idCutomer) {
        return OrderDao.findAllOrderStatus(idCutomer);
    }


}
