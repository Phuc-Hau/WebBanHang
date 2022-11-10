package com.webbanhang.controller.user;

import com.webbanhang.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.service.CookieService;
import com.webbanhang.service.SessionService;



@Controller
@RequestMapping("/account")
public class SignInController {


	@Autowired
	MyUserDetailsService userDetailsService;
	
	@RequestMapping("/signin")
	public String signin( @ModelAttribute("user") Users user ,Model model) {
		return "user/signIn_Up";
	}


	@RequestMapping("logoff")
	public String s() {
		return "forward:/account/signin";
	}

	@RequestMapping("login/error")
	public String e(Model model){
		model.addAttribute("message",false);
		return "forward:/account/signin";
	}

	@RequestMapping("/oauth/signin")
	public String u(OAuth2AuthenticationToken token) {
		userDetailsService.loginFromOAuth2(token);
		return "redirect:/product/index";
	}
	
}
