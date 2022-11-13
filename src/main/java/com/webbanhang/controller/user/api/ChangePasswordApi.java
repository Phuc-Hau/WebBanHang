package com.webbanhang.controller.user.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.UsersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/account/api")

public class ChangePasswordApi {
	
	@Autowired
	UsersService usersService;
	
	@PostMapping("/changepassword")
	public JSONObject updatepassword(@RequestBody JSONObject information , HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		String username = request.getRemoteUser();
		Users user =usersService.findByUsername(username);
		String password = String.valueOf(information.get("password"));
		String newPassword = String.valueOf(information.get("newpassword"));
		if(user.getPassword().equals(password)) {
			user.setPassword(newPassword);
			usersService.update(user);
			obj.put("status",true);
            obj.put("message", "Cập nhật Password Thành công!");
		}
		else {
			obj.put("status",false);
            obj.put("message", "Sai Password Thất bại!");
		}
		
		return obj;
	}

}
