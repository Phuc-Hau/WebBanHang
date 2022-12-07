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
public class ForgotPasswordApi {

    @Autowired
    UsersService usersService;

    @Autowired
    MailerService mailer;

    @Autowired
    ConvenientService convenientUtils;

    Users user;
    String capChas;
    Boolean comfirm = false;

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
    @PostMapping("/email/code/resetcode")
    public void resetcode() throws MessagingException {
        capChas = convenientUtils.ranDomCapCha();
        mailer.sendPassword(user.getEmail(), capChas);
    }


    @PostMapping("/email/code/{code}")
    public JSONObject code(@PathVariable("code") String code) {
        JSONObject obj = new JSONObject();

        if (capChas.equals(code)) {
            obj.put("status",true);
            comfirm = true;
        } else {
            obj.put("message", "Sai mã xác thực không chính xác!");
            obj.put("status",false);
        }
        return obj;
    }

    @PostMapping("/password/{password}")
    public JSONObject updatepassword(@PathVariable("password") String password) {
        JSONObject obj = new JSONObject();
        if(comfirm == true){
            user.setPassword(password);
            try {
                usersService.update(user);
                user = null;
                capChas ="";
                obj.put("status",true);
                obj.put("message", "Cập nhật Password Thành công!");
            } catch (Exception e) {
                // TODO: handle exception
                obj.put("status",false);
                obj.put("message", "Cập nhật Password Thất bại!");
            }
        }else{
            obj.put("status",false);
            obj.put("message", "Chưa xác nhận mã vui lòng thử lại!");
        }
        return obj;
    }

}
