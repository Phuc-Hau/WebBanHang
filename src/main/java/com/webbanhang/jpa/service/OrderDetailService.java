package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.OrderDetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailService {


    List<OrderDetail> findAll();
    OrderDetail findById(Integer id);
    OrderDetail create(OrderDetail entity);
    List<OrderDetail> listCreate(List<OrderDetail> orderDetails);
    OrderDetail update(OrderDetail entity);
    void delete(OrderDetail entity);

    List<OrderDetail> findAllOrderStatust(int idCutomer, int idOrder);
    List<OrderDetail> findAllOrderUsername(int idCutomer);
    boolean existsById(Integer id);

    List<Object> QuantityProduct(int idCutomer);
    List<OrderDetail> orderDetailPay();
    int amountPay(int idProduct);

}
