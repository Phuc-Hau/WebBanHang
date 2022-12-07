package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.jpa.service.GroupProductService;

@Controller
@RequestMapping("/admin")
public class AdminGroupProduct {
	
	@Autowired
    GroupProductService groupProductService;
	
	
	@RequestMapping("/groupproductlist")
	public String adminGroupProductList(Model model) {
		model.addAttribute("adminlistproduct", groupProductService.findAll());
		return "admin/AdminGroupProductList";
	}
	
	@RequestMapping("/groupproduct/edit/{id}")
	public String adminEditGroupProduct() {
		return "admin/AdminGroupProductEdit";
	}

	@RequestMapping("/groupproduct/edit")
	public String adminNewGroupProduct() {
		return "admin/AdminGroupProductEdit";
	}

}
	
