package com.webbanhang.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.service.CookieService;

@Controller
@RequestMapping("/account")
public class ChangePassController {

	@Autowired
	CookieService cookieService;	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/changepass")
	public String changePass() {
		cookieService.add("username", "phuc", 1);
		return "user/changepass";
	}
	
	@PostMapping("/changepassuser")
	public String newpass() {
		return "redirect:/product/index";
	}
}
