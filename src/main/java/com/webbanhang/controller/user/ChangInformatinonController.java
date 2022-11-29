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
@RequestMapping("/account")
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
	public String changInformation(@ModelAttribute("edituser") EditUserAdmin edituser, Model model, HttpServletRequest request) throws InterruptedException {
		String username = request.getRemoteUser();

		Users user =usersService.findByUsername(username);
		if(user !=null) {
			List<OrderDetail> list = orderDetailService.findAllUsername(user.getCutomer().getId());
			model.addAttribute("amountcart", list.size());
		}
		Cutomer cutomer = cutomerService.findById(user.getCutomer().getId());

		edituser.setUser(user);
		edituser.setCutomer(cutomer);

		model.addAttribute("edituser",edituser);
		
		return "ChangInformation";
	}
	
	@PostMapping("/user/update")
	public String changInformation(Model model, @RequestParam("imgs") MultipartFile imgs,
			@ModelAttribute("edituser") EditUserAdmin edituser, HttpServletRequest request) {


		String username = request.getRemoteUser();
		Users useo =usersService.findByUsername(username);
		
			Users user = edituser.getUser();
			user.setRole(useo.getRole());
			user.setStatus(useo.isStatus());
			user.setPassword(useo.getPassword());

			Cutomer cutomer = edituser.getCutomer();
			
			if(!imgs.getOriginalFilename().equals("")) {
				user.setImg(imgs.getOriginalFilename());
			}else {
				user.setImg(usersService.findById(user.getId()).getImg());
			}
			
			user.setCutomer(cutomer);
		   
			try {
				cutomerService.update(cutomer);
				usersService.update(user);
				convenientUtils.saveFile(imgs, "user");
			} catch (Exception e) { 
				e.printStackTrace();
			}
			return"redirect:/account/changinformation";
	}
}
