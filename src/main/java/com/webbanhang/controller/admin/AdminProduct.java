package com.webbanhang.controller.admin;

import java.util.List;

import com.webbanhang.jpa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.jpa.dao.GroupProductDao;
import com.webbanhang.jpa.dao.ProductDao;
import com.webbanhang.jpa.model.GroupProduct;

@Controller
@RequestMapping("/admin")
public class AdminProduct {
	@Autowired
	ProductDao productDao;

	@Autowired
	GroupProductDao groupProductDao;

	@RequestMapping("/productlist")
	public String adminProductList(Model model) {
		model.addAttribute("adminlistproduct", productDao.findAll());
		return "admin/AdminProductList";
	}

	@RequestMapping("/product/edit/{id}")
	public String adminEditProductList(Model model, @PathVariable("id") int id) {
		model.addAttribute("product", productDao.getById(id));
		return "admin/AdminProductEdit";
	}

	@RequestMapping("/product/update")
	public String updateproduct(Model model, @ModelAttribute("product") Product product, @RequestParam("groups") String group) {
		System.out.println(group);
		return "redirect:/admin/product/edit/"+product.getId();
	}

	@ModelAttribute("groupproduct")
	public List<GroupProduct> getFaculties() {
		List<GroupProduct> list = groupProductDao.findAll();
		return list;
	}
}
