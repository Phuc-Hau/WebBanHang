package com.webbanhang.controller;


import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.ProductService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.jpa.dao.OrderDetailDao;
import com.webbanhang.service.CookieService;
import com.webbanhang.service.SessionService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class IndexProductController {
	
	@Autowired
	ProductService productService;



	@RequestMapping("/product/index")
	public String index(Model model) {		

		model.addAttribute("product",productService.findAllStatus());
		model.addAttribute("fashsale",productService.fashSale());
		model.addAttribute("productSY",productService.productSY());
		return "index";
	}
	
	@RequestMapping("/product/all")
	public String allProduct(Model model) {
		model.addAttribute("product",productService.findAllStatus());
		return "body/xuhuongsp";
	}

	@RequestMapping("/product/{nameGroup}/{id}")
	public String productGroup(Model model, @PathVariable("nameGroup") String nameGroup, @PathVariable("id") int id){
		model.addAttribute("nameGroup",nameGroup);
		model.addAttribute("productGroup",productService.getProductGroup(id));
		return "body/productGroup";
	}

	@RequestMapping("/product/search")
	public String searchProduct(Model model,@RequestParam("KeyWord") String KeyWord){
		List<Product> list = productService.searchKeyWord(KeyWord);
		return "";
	}

	@RequestMapping("/500")
	public String er(){
		return "404";
	}
}
