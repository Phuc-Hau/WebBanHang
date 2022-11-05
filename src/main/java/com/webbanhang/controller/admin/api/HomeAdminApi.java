package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.CharIn;
import com.webbanhang.jpa.model.MoneyMonth;
import com.webbanhang.jpa.model.Statistical;
import com.webbanhang.jpa.service.OrderService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class HomeAdminApi {

    @Autowired
    OrderService orderService;

    @RequestMapping("/api/char")
    public CharIn chars(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        simpleDateFormat.applyPattern("YYYY");
        String year = simpleDateFormat.format(new Date());

        List<MoneyMonth> moneyMonth = orderService.moneyMonthYear(Integer.parseInt(year));
        int months[] = new int[12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < moneyMonth.size(); j++) {
                if (moneyMonth.get(j).getMonth() == i+1) {
                    months[i] = (int) moneyMonth.get(j).getMoney();
                    break;
                } else {
                    months[i] = 0;
                }
            }
        }
        CharIn charin =new CharIn();
        charin.setCharMonth(months);
        return  charin;
    }

    @RequestMapping("/api/home")
    public Statistical in() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        simpleDateFormat.applyPattern("MM");
        String month = simpleDateFormat.format(new Date());

        simpleDateFormat.applyPattern("YYYY");
        String year = simpleDateFormat.format(new Date());

        int sumPriceMonth =0;
        try {
            sumPriceMonth = orderService.sumPriceMonth(Integer.parseInt(month));
        }catch (Exception e){
            sumPriceMonth = 0;
        }

        int sumCount = orderService.sumCountMonth(Integer.parseInt(month));
        int sumPriceYear = orderService.sumPriceYear(Integer.parseInt(year));

        Statistical statistical  = new Statistical();
        statistical.setMonth(month);
        statistical.setYear(year);
        statistical.setSumpricemonth(sumPriceMonth);
        statistical.setSumcount(sumCount);
        statistical.setSumpriceyear(sumPriceYear);

        return statistical;

    }
}
