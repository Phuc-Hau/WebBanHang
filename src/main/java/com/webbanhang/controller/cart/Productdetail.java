package com.webbanhang.controller.cart;

import java.util.List;

import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.service.SessionService;


@Controller
public class Productdetail {

	
	@RequestMapping
	public String d () {
		return "redirect:/product/index";
	}
	
	@GetMapping("/product/sale/{id}")
	public String doGetFL(@PathVariable("id") int id, Model model) {
		return "cart/productdetail";
	}
	
	@GetMapping("/product/sanpham/{id}")
	public String doGetXH(@PathVariable("id") int id,  Model model) {
		return "cart/productdetail";
	}
}
