package com.webbanhang.jpa.dao;


import com.webbanhang.jpa.model.CountMonth;
import com.webbanhang.jpa.model.MoneyMonth;
import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.model.TotalMoneyInTheLast3Years;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

	@Query("select new CountMonth(o.status, COUNT(o))  from Order o where o.status != 0 and year(o.date)= year(now()) and MONTH(o.date) = ?1 group by o.status")
	List<CountMonth> findAllOrderStatusMonth(int idcutomer);

	@Query("select o from Order o where o.status != 0 and o.cutomer.id= ?1 ")
	List<Order> findAllOrderStatus(int idcutomer);

	@Query("select o from Order o where o.status = 0 and o.cutomer.id= ?1 ")
	Order findIdCutomer(int i);

	@Query("SELECT SUM(o.quantity*(o.product.price-o.product.price*o.product.sale)) "
			+ "  FROM OrderDetail o where o.order.id = ?1")
	int sumPriceOrder(int idOrder);

	@Query("SELECT sum(o.totalmoney) FROM Order o where o.status = 4 and year(o.date) = year(now())   and MONTH(o.date) = ?1 ")
	int sumPriceMonth(int month);


	@Query("SELECT sum(o.totalmoney) FROM Order o where o.status = 4 and YEAR(o.date) = ?1 ")
	int sumPriceYear(int year);

	@Query("SELECT COUNT(o) FROM Order o where o.status != 0 and year(o.date)= year(now())  and MONTH(o.date) = ?1 ")
	int sumCountMonth(int month);

	@Query("SELECT new MoneyMonth( MONTH(o.date) , Sum(o.totalmoney)) "
			+ "FROM  Order o "
			+" where o.status =4 and Year(o.date)= ?1 "
			+ "GROUP BY MONTH(o.date) ")
	List<MoneyMonth> moneyMonthYear(int year);

	@Query("SELECT new CountMonth( MONTH(o.date) , count(o.date)) "
			+ "FROM  Order o "
			+" where o.status!=0 and Year(o.date)= ?1 "
			+ "GROUP BY MONTH(o.date) ")
	List<CountMonth> countMonthYear(int year);

	@Query(value = "CALL Total_Money_In_The_Last_3_Years();", nativeQuery = true)
	Object TotalMoneyInTheLast3Years();


}
