package com.webbanhang.controller.user;

import java.util.List;

import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.EditUserAdmin;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.service.SessionService;
import com.webbanhang.service.ConvenientService;

import javax.servlet.http.HttpServletRequest;

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
