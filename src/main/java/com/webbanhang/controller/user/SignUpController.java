package com.webbanhang.controller.user;


import javax.mail.MessagingException;

import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.jpa.dao.CutomerDao;
import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.service.ConvenientService;
import com.webbanhang.service.MailerService;

@Controller
@RequestMapping("/account")
public class SignUpController extends Thread{

	
	@RequestMapping("/signup")
	public String showForm() {
		return "user/signIn_Up";
	}



}
