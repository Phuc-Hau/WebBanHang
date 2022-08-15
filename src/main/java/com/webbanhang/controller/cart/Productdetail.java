package com.webbanhang.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.jpa.dao.OrderDetailDao;
import com.webbanhang.jpa.dao.ProductDao;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.service.SessionService;


@Controller
public class Productdetail {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	SessionService session;
	
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@RequestMapping
	public String d (Model model) {

		return "redirect:/product/index";
	}
	
	@GetMapping("/product/sale/{id}")
	public String doGetFL(@PathVariable("id") int id, Model model) {
		Users user =session.get("user");
		if(user !=null) {
			List<OrderDetail> list = orderDetailDao.findAllUsername(user.getCutomer().getId());
			model.addAttribute("amountcart", list.size());
		}
		model.addAttribute("chitiet",productDao.getById(id));
		return "cart/productdetail";
	}
	
	@GetMapping("/product/sanpham/{id}")
	public String doGetXH(@PathVariable("id") int id,  Model model) {
		Users user =session.get("user");
		if(user !=null) {
			List<OrderDetail> list = orderDetailDao.findAllUsername(user.getCutomer().getId());
			model.addAttribute("amountcart", list.size());
		}
		model.addAttribute("chitiet",productDao.getById(id));
		return "cart/productdetail";
	}
}
