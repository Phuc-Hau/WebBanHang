package com.webbanhang.controller.admin;

import java.util.List;

import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.GroupProductService;
import com.webbanhang.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.jpa.model.GroupProduct;

@Controller
@RequestMapping("/admin")
public class AdminProduct {
	@Autowired
	ProductService productService;

	@Autowired
	GroupProductService groupProductService;

	@RequestMapping("/productlist")
	public String adminProductList(Model model) {
		model.addAttribute("adminlistproduct", productService.findAll());
		return "admin/AdminProductList";
	}

	@RequestMapping("/product/edit/{id}")
	public String adminEditProduct() {
		return "admin/AdminProductEdit";
	}

	@RequestMapping("/product/edit")
	public String adminNewProduct() {
		return "admin/AdminProductEdit";
	}

	@RequestMapping("/product/update")
	public String updateProduct(Model model, @ModelAttribute("product") Product product, @RequestParam("groups") String group) {
		System.out.println(group);
		return "redirect:/admin/product/edit/"+product.getId();
	}



}
