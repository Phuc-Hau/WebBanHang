package com.webbanhang.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminOrderDetail {

	@RequestMapping("/orderlist")
	public String adminUserList() {
		return "admin/AdminOrderList";
	}


}
