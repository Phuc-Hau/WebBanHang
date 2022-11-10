package com.webbanhang.controller.user.api;

import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.UsersService;
import com.webbanhang.service.ConvenientService;
import com.webbanhang.service.MailerService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@CrossOrigin("*")
@RestController
@RequestMapping("/account/api")
public class ForGhetPassWordApi {

    @Autowired
    UsersService usersService;

    @Autowired
    MailerService mailer;

    @Autowired
    ConvenientService convenientUtils;

    Users user;
    String capChas;

    @RequestMapping("/email/{email}")
    public JSONObject capcha(@PathVariable("email") String email) throws MessagingException {

        user = usersService.findByEmail(email);
        JSONObject obj = new JSONObject();

        if (user == null) {
            obj.put("status",false);
            obj.put("message", "Email chưa đăng ký tài khoản");
        } else {
            obj.put("status",true);
            capChas = convenientUtils.ranDomCapCha();

            mailer.sendPassword(email, capChas);
            obj.put("email", convenientUtils.emailToStar(email));
        }
        return obj;
    }

    @PostMapping("/code/{code}")
    public JSONObject code(@PathVariable("code") String code) {
        JSONObject obj = new JSONObject();

        if (capChas.equals(code)) {
            obj.put("status",true);
        } else {
            obj.put("message", "Sai mã xác thực không chính xác!");
            obj.put("status",false);
        }
        return obj;
    }

    @PostMapping("/password/{password}")
    public String updatepassword(@PathVariable("password") String password) {
        user.setPassword(password);
        try {
            usersService.update(user);
            user = null;
            capChas ="";
            return "forward:/account/signin";
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

}
