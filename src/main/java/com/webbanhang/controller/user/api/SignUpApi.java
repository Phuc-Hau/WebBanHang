package com.webbanhang.controller.user.api;

import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.CutomerService;
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
public class SignUpApi {
    @Autowired
    MailerService mail;

    @Autowired
    ConvenientService convenientUtils;

    @Autowired
    UsersService usersService;

    @Autowired
    CutomerService cutomerService;

    Users tymUser;
    Cutomer tymCutomer;
    String capchas = "";

    @PostMapping("/signup/resetcode")
    public void resetcode() throws MessagingException {
        capchas = convenientUtils.ranDomCapCha();
        mail.sendSignUp(tymUser.getEmail(), capchas);
    }

    @PostMapping("/signup/new")
    public JSONObject checkUser(@RequestBody JSONObject data) throws MessagingException {

        JSONObject obj = new JSONObject();
        Users user = new Users();
        user.setPassword(String.valueOf(data.get("password")));
        user.setUsername(String.valueOf(data.get("username")));
        user.setEmail(String.valueOf(data.get("email")));
        if(usersService.findByUsername(user.getUsername()) == null){
            if (usersService.findByEmail( user.getEmail() )== null) {

                Cutomer cutomer = new Cutomer();
                cutomer.setName(String.valueOf(data.get("fullname")));

                user.setCutomer(cutomer);
                tymCutomer = cutomer;
                tymUser = user;

                capchas = convenientUtils.ranDomCapCha();

                mail.sendSignUp(user.getEmail(), capchas);

                obj.put("status",true);
                obj.put("message","Chờ nhận capcha");
                obj.put("email", convenientUtils.emailToStar(user.getEmail()));
            } else {
                obj.put("status",false);
                obj.put("message","Email đã đăng ký tài khoản");
            }
        }else{
            obj.put("status",false);
            obj.put("message","Username đã tồn tại!");
        }

        return obj;
    }

    @PostMapping("/signup/confirm/{code}")
    public JSONObject signUp(@PathVariable("code") String code) {
        JSONObject obj = new JSONObject();
        if (code.equals(capchas)) {
            try {
                cutomerService.create(tymCutomer);
                usersService.create(tymUser);
                obj.put("status",true);
                obj.put("message", "Tạo tài khoản thành công!");
            } catch (Exception e) {
                obj.put("status",false);
                obj.put("message", "Tạo tài khoản thất bại!");
            }
        } else {
            obj.put("status",false);
            obj.put("message", "Sai mã xác thực không chính xác!");
        }
        return obj;
    }
}
