package com.webbanhang.controller.cart.api;

import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Orderstatus;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.OrderService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class CartApi {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	OrderService orderService;

	@Autowired
	UsersService userService;


	@GetMapping("/list")
	public List<OrderDetail> cart(HttpServletRequest request) {

		String username = request.getRemoteUser();

		Users user =userService.findByUsername(username);

		List<OrderDetail> list = orderDetailService.findAllUsername(user.getCutomer().getId());

		return list;
	}
	
	@GetMapping("/cart/{p}/{id}")
	public void cart (@PathVariable("p")String p,@PathVariable("id") int id) {
		try {
		    OrderDetail orderDetail	= orderDetailService.findById(id);
		    if(p.equals("plus")) {
		    	orderDetail.setQuantity(orderDetail.getQuantity()+1);
		    }else if(p.equals("pre") && orderDetail.getQuantity()>0) {
		    	orderDetail.setQuantity(orderDetail.getQuantity()-1);
		    }
		    orderDetailService.create(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@PostMapping("/cart/delete/{id}")
	public void deleteCart(@PathVariable("id") int id) {
		OrderDetail orderDetail = orderDetailService.findById(id);
		orderDetailService.delete(orderDetail);
	}

	@PostMapping("/cart/newpay")
	public void Pay(HttpServletRequest request) {

		String username = request.getRemoteUser();

		int idCutomer = userService.findByUsernameGetIdCutomer(username);

		List<OrderDetail> list = orderDetailService.findAllUsername(idCutomer);
		int priceSum = 20000;
		
		for (OrderDetail orderDetail : list) {
			priceSum+= (orderDetail.getProduct().getPrice()-orderDetail.getProduct().getPrice()
					*orderDetail.getProduct().getSale())*orderDetail.getQuantity();
		}

		Order order = orderService.findIdCutomer(idCutomer);
		order.setStatus(1);
		order.setTotalmoney(priceSum); 
		orderService.create(order);
	}
}
