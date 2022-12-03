package com.webbanhang.controller.user;

import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.service.SessionService;
import com.webbanhang.service.ConvenientService;

@Controller
@RequestMapping("/accounts")
public class ChangInformatinonController {
	@Autowired
	UsersService usersService;
	
	@Autowired
	CutomerService cutomerService;
	
	@Autowired
	ConvenientService convenientUtils;
	
	@Autowired
	SessionService session;
	
	@Autowired
	OrderDetailService orderDetailService;

	@RequestMapping("/changinformation")
	public String changInformation() throws InterruptedException {
		return "user/ChangInformation";
	}

}
