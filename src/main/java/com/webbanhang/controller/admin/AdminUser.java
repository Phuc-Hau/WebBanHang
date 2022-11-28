package com.webbanhang.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminUser {

	@RequestMapping("/userlist")
	public String adminUserList() {
		return "admin/AdminUserList";
	}

	@RequestMapping("/user/edit/user={id}")
	public String adminUserEditID(){
		return "admin/AdminUserEdit";
	}
	

}
