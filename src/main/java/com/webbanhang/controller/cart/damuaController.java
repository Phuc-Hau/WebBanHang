package com.webbanhang.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class damuaController {
    @GetMapping("/purchased")
    public String cart() {
        return "cart/purchased";
    }
}
