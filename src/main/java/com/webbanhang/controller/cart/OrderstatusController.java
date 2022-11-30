package com.webbanhang.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class OrderstatusController {
    @GetMapping("/orderstatus")
    public String cart() {
        return "cart/orderstatus";
    }
}
