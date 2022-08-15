package com.webbanhang.controller.user;


import javax.mail.MessagingException;

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

	@Autowired
	MailerService mail;

	@Autowired
	ConvenientService convenientUtils;

	@Autowired
	UserDao userDao;

	@Autowired
	CutomerDao cutomerDao;
	
	@RequestMapping("/signup")
	public String showForm(@ModelAttribute("user") Users user) {
		return "user/singup";
	}

	Users tymUser;
	Cutomer tymCutomer;
	String capchas = "";

	@PostMapping("/signup/confirm")
	public String senEmail(Model model, @ModelAttribute("user") Users user,
						   @RequestParam("fullname") String fullname) throws MessagingException {
		if (userDao.findByEmail(user.getEmail()) == null) {

			Cutomer cutomer = new Cutomer();
			cutomer.setName(fullname);

			user.setCutomer(cutomer);
			tymCutomer = cutomer;
			tymUser = user;


			model.addAttribute("email", convenientUtils.emailToStar(user.getEmail()));

			capchas = convenientUtils.ranDomCapCha();

			mail.sendSignUp(tymUser.getEmail(), capchas);

			model.addAttribute("message", "");
			return "user/capchasignup";

		} else {
			model.addAttribute("message", "Email đã tồn tại!");
			return "user/singup";
		}
	}



	@PostMapping("/confirm")
	public String signUp(Model model, @RequestParam("capcha") String capcha) {
		
		if (capcha.equals(capchas)) {
			try {
				cutomerDao.save(tymCutomer);
				userDao.save(tymUser);
			} catch (Exception e) {
				System.out.println("User da ton tai");
				return "user/capchasignup";
			}
			return "redirect:/account/signin";
		} else {
			model.addAttribute("message", "Sai mã xác thực không chính xác!");
			return "user/capchasignup";
		}

	}

}
