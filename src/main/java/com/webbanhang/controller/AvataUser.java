package com.webbanhang.controller;

import com.webbanhang.jpa.service.UsersService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AvataUser {
    @Autowired
    UsersService usersService;

    @PostMapping("/avata/user/{id}")
    public JSONObject avata(@PathVariable("id") int id){
        JSONObject job = new JSONObject();
        job.put("img",usersService.imgIdCutomer(id));
        return job;
    }
}
