package com.webbanhang.jpa.dao;


import com.webbanhang.jpa.model.MoneyMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webbanhang.jpa.model.Order;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

	@Query("select o from Order o where o.status = 0 and o.cutomer.id= ?1 ")
	Order findIdCutomer(int i);
	
	@Query("SELECT SUM(o.quantity*(o.product.price-o.product.price*o.product.sale)) "
			+ "  FROM OrderDetail o where o.order.id = ?1")
	int sumPriceOrder(int idOrder);

	@Query("SELECT sum(o.totalmoney) FROM Order o where o.status = 1 and MONTH(o.date) = ?1 ")
	int sumPriceMonth(int month);


	@Query("SELECT sum(o.totalmoney) FROM Order o where o.status = 1 and YEAR(o.date) = ?1 ")
	int sumPriceYear(int year);
	
	@Query("SELECT COUNT(o) FROM Order o where o.status = 1 and MONTH(o.date) = ?1 ")
	int sumCountMonth(int month);

	@Query("SELECT new MoneyMonth( MONTH(o.date) , Sum(o.totalmoney)) "
			+ "FROM  Order o "
			+" where o.status =1 and Year(o.date)= ?1 "
			+ "GROUP BY MONTH(o.date) ")
	List<MoneyMonth> moneyMonthYear(int year);
}
