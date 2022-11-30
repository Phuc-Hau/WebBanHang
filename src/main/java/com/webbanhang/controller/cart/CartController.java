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
@RequestMapping("/accounts")
public class CartController {


	@GetMapping("/cart")
	public String cart() {
		return "cart/cart";
	}


}
