package com.webbanhang.controller.admin;


import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.EditUserAdmin;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.service.ConvenientService;

@Controller
@RequestMapping("/admin")
public class AdminUser {
	
	@Autowired
	UsersService userService;
	
	@Autowired
	CutomerService cutomerService;
	
	@Autowired
    ConvenientService convenientUtils;

	@RequestMapping("/userlist")
	public String adminUserList(Model model) {
		model.addAttribute("adminlistuser", userService.findAll());
		return "admin/AdminUserList";
	}
	
	@RequestMapping("/useredit")
	public String adminUserEdit(@ModelAttribute("edituser") EditUserAdmin edituser) {
		return "admin/AdminUserEdit";
	}
	
	@RequestMapping("/user/edit/{id}")
	public String adminUserEditID(Model model,@PathVariable("id") int id,
			@ModelAttribute("edituser") EditUserAdmin edituser) {
		Users user = userService.findById(id);
		Cutomer cutomer = cutomerService.findById(user.getCutomer().getId());
		edituser.setUser(user);
		edituser.setCutomer(cutomer);
		model.addAttribute("edituser", edituser);
		return "admin/AdminUserEdit";
	}
	
	@PostMapping("/user/update")
	public String i(Model model, @RequestParam("imgs") MultipartFile imgs,
			@ModelAttribute("edituser") EditUserAdmin edituser) {
		Users user = edituser.getUser();
		Cutomer cutomer = edituser.getCutomer();
		
		if(!imgs.getOriginalFilename().equals("")) {
			user.setImg(imgs.getOriginalFilename());
		}else {
			user.setImg(userService.findById(user.getId()).getImg());
		}
		
		user.setCutomer(cutomer);
		try {
			cutomerService.update(cutomer);
			userService.update(user);
			convenientUtils.saveFile(imgs, "user");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return "redirect:/admin/user/edit/"+edituser.getUser().getId();
	}
}
