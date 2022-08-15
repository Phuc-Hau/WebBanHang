package com.webbanhang.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webbanhang.jpa.dao.CutomerDao;
import com.webbanhang.jpa.dao.OrderDetailDao;
import com.webbanhang.jpa.dao.UserDao;
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
	UserDao userDao;
	
	@Autowired
	CutomerDao cutomerDao;
	
	@Autowired
	ConvenientService convenientUtils;
	
	@Autowired
	SessionService session;
	
	@Autowired
	OrderDetailDao orderDetailDao;

	@RequestMapping("/changinformation")
	public String changInformation(@ModelAttribute("edituser") EditUserAdmin edituser, Model model, HttpServletRequest request) throws InterruptedException {
		String username = request.getRemoteUser();

		Users user =userDao.findByUsername(username);
		if(user !=null) {
			List<OrderDetail> list = orderDetailDao.findAllUsername(user.getCutomer().getId());
			model.addAttribute("amountcart", list.size());
		}
		Cutomer cutomer = cutomerDao.getById(user.getCutomer().getId());

		edituser.setUser(user);
		edituser.setCutomer(cutomer);

		model.addAttribute("edituser",edituser);
		
		return "user/ChangInformation";
	}
	
	@PostMapping("/user/update")
	public String changInformation(Model model, @RequestParam("imgs") MultipartFile imgs,
			@ModelAttribute("edituser") EditUserAdmin edituser, HttpServletRequest request) {


		String username = request.getRemoteUser();
		Users useo =userDao.findByUsername(username);
		
			Users user = edituser.getUser();
			user.setRole(useo.getRole());
			user.setStatus(useo.isStatus());
			Cutomer cutomer = edituser.getCutomer();
			
			if(!imgs.getOriginalFilename().equals("")) {
				user.setImg(imgs.getOriginalFilename());
			}else {
				user.setImg(userDao.getById(user.getId()).getImg());
			}
			
			user.setCutomer(cutomer);
		   
			try {
				cutomerDao.save(cutomer);
				userDao.save(user);
				convenientUtils.saveFile(imgs, "user");
			} catch (Exception e) { 
				e.printStackTrace();
			}
			return"redirect:/account/changinformation";
	}
}
