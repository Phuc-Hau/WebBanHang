package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusDao extends JpaRepository<OrderStatus, Integer> {
}