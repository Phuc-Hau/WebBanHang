package com.webbanhang.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class CartController {


	@GetMapping("/cart")
	public String cart() {
		return "cart/cart";
	}


}
