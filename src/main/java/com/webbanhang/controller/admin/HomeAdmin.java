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

    @Autowired
    OrderService orderService;



    @RequestMapping("/index")
    public String index(Model model) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("MM");
        String month = simpleDateFormat.format(new Date());
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

//        String data = "var datamonth= "+Arrays.toString(months);
//        String dir = "src/main/resources/static/js/datamonth.js";
//
//        try {
//            FileWriter fileWriter = new FileWriter(dir);
//            fileWriter.write(data);
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "admin/AdminIndex";
    }
}
