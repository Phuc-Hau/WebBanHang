package com.webbanhang.controller.user.api;

import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.UsersService;
import com.webbanhang.service.ConvenientService;
import com.webbanhang.service.FileManagerService;
import com.webbanhang.service.SessionService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@CrossOrigin("*")
@RestController
@RequestMapping("/accounts/api")
public class ChangInformationApi {
    @Autowired
    UsersService usersService;

    @Autowired
    CutomerService cutomerService;

    @Autowired
    FileManagerService filemanager;


    @RequestMapping("/changinformation")
    public Users changInformation(HttpServletRequest request){
        String username = request.getRemoteUser();
        Users user = usersService.findByUsername(username);
        return user;
    }

    @PostMapping("/user/update")
    public JSONObject update(@RequestBody Users users) {
        JSONObject obj = new JSONObject();
        Users u = usersService.findById(users.getId());
        String img = u.getImg();
        try {

            usersService.update(users);
            try{
                if(!users.getImg().equals(img)){
                    filemanager.delete("user",img);
                }

            } catch (Exception e){

            }
            Cutomer cutomer = users.getCutomer();
            cutomerService.update(cutomer);
            obj.put("status",true);
            obj.put("message", "Cập nhật user "+users.getUsername()+" Thành công!");
        } catch (Exception e) {
            obj.put("status",false);
            obj.put("message", "Cập nhật user "+users.getUsername()+" Thất bại!");
        }

        return obj;
    }


}
