package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.CountMonth;
import com.webbanhang.jpa.model.MoneyMonth;
import com.webbanhang.jpa.model.Order;

import java.util.List;

public interface OrderService {

        List<Order> findAll();
        Order findById(Integer id);
        Order create(Order entity);
        Order update(Order entity);

        boolean existsById(Integer id);

        int sumPriceOrder(int idOrder);
        int sumPriceMonth(int month);
        int sumPriceYear(int year);
        int sumCountMonth(int month);
        List<MoneyMonth> moneyMonthYear(int year);
        List<CountMonth> countMonthYear(int year);
        List<CountMonth> findAllOrderStatusMonth(int month);
        List<Order> findAllOrderStatus(int idCutomer);
        Object TotalMoneyInTheLast3Years();

}
