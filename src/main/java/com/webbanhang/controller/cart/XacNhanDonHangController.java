package com.webbanhang.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class XacNhanDonHangController {

    @GetMapping("accounts/xacnhandonhang")
    public String xn (){
        return "cart/donhang";
    }
}
