package com.webbanhang.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webbanhang.jpa.model.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer>{

	@Query("SELECT o FROM OrderDetail o WHERE o.order.cutomer.id = ?1 and o.order.status = 0")
	List<OrderDetail> findAllUsername(int idcutomer);
	
	@Query("SELECT o FROM OrderDetail o WHERE o.product.id = ?1 and o.order.cutomer.id = ?2 and o.order.status = 0")
	OrderDetail findIdProduct(int idProduct, int idCutomer);

	@Query("SELECT o FROM OrderDetail o WHERE o.order.cutomer.id = ?1 and o.order.status != 0 and o.order.id= ?2")
	List<OrderDetail> findAllOrderStatust(int idcutomer, int idOrder);

	@Query("SELECT o FROM OrderDetail o WHERE o.order.cutomer.id = ?1 and o.order.status != 0 Order By o.order.date Desc")
	List<OrderDetail> findAllOrderUsername(int idCutomer);

	@Query("SELECT sum(o.quantity) FROM OrderDetail o where o.order.status = 4 and o.product.id = ?1 ")
	int amountPay (int idProduct);

	@Query("SELECT o FROM OrderDetail o where o.order.status = 4")
	List<OrderDetail> orderDetailPay ();

	@Query("SELECT o FROM OrderDetail o where o.order.status = 4 and o.product.id = ?1 ")
	List<OrderDetail> orderDetailPay (int idProduct);

	@Query(value = "CALL QuantityProduct(?1);", nativeQuery = true)
	List<Object> QuantityProduct(int idCutomer);
	
}
