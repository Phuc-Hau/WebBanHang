package com.webbanhang.controller.cart;

import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.webbanhang.jpa.model.OrderDetail;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class CartController {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

	@Autowired
	UsersService userService;

	@Autowired
	CutomerService cutomerService;

	@GetMapping("/cart")
	public String cart() {
		return "cart/cart";
	}


	@PostMapping("/newcart")
	public String newCart(@RequestParam("quantity") int quantity,@RequestParam("id") int id,HttpServletRequest request) {

		Product product = productService.findById(id);

		int idCutomer =userService.findByUsernameGetIdCutomer(request.getRemoteUser());
		
		Order order = orderService.findIdCutomer(idCutomer);

		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setProduct(product);
		orderDetail.setQuantity(quantity);

		try {
			if(order != null) {
				OrderDetail orderDetailTym = orderDetailService.findIdProduct(product.getId(),idCutomer);

				if(orderDetailTym == null) {
					orderDetail.setOrder(order);
					orderDetailService.create(orderDetail);
				}else {
					orderDetailTym.setQuantity(orderDetailTym.getQuantity()+quantity);
					orderDetailService.create(orderDetailTym);
				}

			}else {
				Order order2 = new Order();

				order2.setStatus(0);
				order2.setCutomer(cutomerService.findById(idCutomer));

				orderService.create(order2);

				orderDetail.setOrder(order2);
				orderDetailService.create(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/product/sanpham/"+id;
	}

}
