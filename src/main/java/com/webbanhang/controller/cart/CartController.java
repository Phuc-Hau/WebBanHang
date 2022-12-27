package com.webbanhang.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

	@GetMapping("/shopping/cart")
	public String cart() {
		return "cart/cart";
	}

	@GetMapping("accounts/xacnhandonhang")
	public String xn (){
		return "cart/donhang";
	}


}
