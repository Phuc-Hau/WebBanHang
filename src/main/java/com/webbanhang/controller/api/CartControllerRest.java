package com.webbanhang.controller.api;

import com.webbanhang.jpa.dao.*;
import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class CartControllerRest {
	
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@Autowired
	OrderDao orderDao; 

	@Autowired
	UserDao userDao;


	@GetMapping("/list")
	public List<OrderDetail> cart(HttpServletRequest request) {

		String username = request.getRemoteUser();
		System.out.println(username);
		Users user =userDao.findByUsername(username);

		List<OrderDetail> list = orderDetailDao.findAllUsername(user.getCutomer().getId());

		return list;
	}
	
	@GetMapping("/cart/{p}/{id}")
	public void cart (@PathVariable("p")String p,@PathVariable("id") int id) {
		try {
		    OrderDetail orderDetail	= orderDetailDao.getById(id);
		    if(p.equals("plus")) {
		    	orderDetail.setQuantity(orderDetail.getQuantity()+1);
		    }else if(p.equals("pre") && orderDetail.getQuantity()>0) {
		    	orderDetail.setQuantity(orderDetail.getQuantity()-1);
		    }
		    orderDetailDao.save(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@PostMapping("/cart/delete/{id}")
	public void deleteCart(@PathVariable("id") int id) {
		OrderDetail orderDetail = orderDetailDao.getById(id);
		orderDetailDao.delete(orderDetail);
	}

	@PostMapping("/cart/newpay")
	public void Pay(HttpServletRequest request) {

		String username = request.getRemoteUser();

		int idCutomer = userDao.findByUsernameGetIdCutomer(username);

		List<OrderDetail> list = orderDetailDao.findAllUsername(idCutomer);
		double priceSum = 20000;
		
		for (OrderDetail orderDetail : list) {
			priceSum+= (orderDetail.getProduct().getPrice()-orderDetail.getProduct().getPrice()
					*orderDetail.getProduct().getSale())*orderDetail.getQuantity();
		}

		Order order = orderDao.findIdCutomer(idCutomer);
		order.setStatus(true);
		order.setTotalmoney(priceSum); 
		orderDao.save(order);
	}
}
