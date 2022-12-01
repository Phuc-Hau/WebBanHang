package com.webbanhang.controller;


import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.ProductService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.jpa.dao.OrderDetailDao;
import com.webbanhang.service.CookieService;
import com.webbanhang.service.SessionService;


@Controller
public class IndexProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UsersService userService;
	
	@Autowired
	SessionService session;
	

	@Autowired
	CookieService cookie;


	@RequestMapping("/product/index")
	public String index(Model model) {		
//		User users = userService.checkLogin(cookie.getValue("username"), cookie.getValue("password"));
//
//		if(users != null) {
//			session.set("user", users);
//		}
//		User user =session.get("user");
//		if(user !=null) {
//			List<OrderDetail> list = orderDetailDao.findAllUsername(user.getCutomer().getId());
//			model.addAttribute("amountcart", list.size());
//		}

		model.addAttribute("product",productService.findAll());
		
		return "index";
	}
	
	@RequestMapping("/product/xuhuongsp")
	public String allProduct(Model model) {		
//		User users = userService.checkLogin(cookie.getValue("username"), cookie.getValue("password"));
//
//		if(users != null) {
//			session.set("user", users);
//		}
//		User user =session.get("user");
//		if(user !=null) {
//			List<OrderDetail> list = orderDetailDao.findAllUsername(user.getCutomer().getId());
//			model.addAttribute("amountcart", list.size());
//		}

		model.addAttribute("product",productService.findAll());
		
		return "body/xuhuongsp";
	}
	

	@RequestMapping("/500")
	public String er(){
		return "404";
	}
}
