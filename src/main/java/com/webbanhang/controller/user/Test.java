package com.webbanhang.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("/signIn")
    public String signup(Model model){
        return "user/signIn_Up";
    }
}
