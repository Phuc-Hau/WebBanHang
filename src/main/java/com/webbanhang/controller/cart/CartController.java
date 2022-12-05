package com.webbanhang.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping")
public class CartController {


	@GetMapping("/cart")
	public String cart() {
		return "cart/cart";
	}


}
