package com.webbanhang.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class ForgetPassController {


	@RequestMapping("/forgetpass")
	public String searchTK() {
		return "user/forgetpassword";
	}

	
}
