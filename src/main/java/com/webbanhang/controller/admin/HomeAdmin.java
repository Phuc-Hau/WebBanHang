package com.webbanhang.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.webbanhang.jpa.model.MoneyMonth;
import com.webbanhang.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class HomeAdmin {


    @RequestMapping("/index")
    public String index(Model model) {


        return "admin/AdminIndex";
    }
}
