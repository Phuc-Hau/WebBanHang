package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.CutomerService;
import com.webbanhang.jpa.service.UsersService;
import com.webbanhang.service.FileManagerService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class UserAdminApi {
    @Autowired
    UsersService userService;

    @Autowired
    CutomerService cutomerService;

    @Autowired
    FileManagerService filemanager;

    @RequestMapping("/userlist")
    public List<Users> adminUserList() {
        return userService.findAll();
    }

    @RequestMapping("/user/edit/user={id}")
    public Users adminUserEditID(@PathVariable("id") int id) {
        Users user = userService.findById(id);
        return user;
    }

    @PostMapping("/user/update")
    public JSONObject update(@RequestBody Users users) {
        JSONObject obj = new JSONObject();
        Users u = userService.findById(users.getId());
        String img = u.getImg();
        try {
            userService.update(users);
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
            e.printStackTrace();
            obj.put("status",false);
            obj.put("message", "Cập nhật user "+users.getUsername()+" Thất bại!");
        }

        return obj;
    }
}
