package com.webbanhang.controller.user;

import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.service.CookieService;

@Controller
@RequestMapping("/accounts")
public class ChangePassController {

	
	@RequestMapping("/changepass")
	public String changePass() {
		return "user/changepass";
	}
	
	@PostMapping("/changepassuser")
	public String newpass() {
		return "redirect:/product/index";
	}
}
