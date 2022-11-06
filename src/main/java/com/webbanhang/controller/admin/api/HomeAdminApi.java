package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.*;
import com.webbanhang.jpa.service.OrderService;
import com.webbanhang.service.ConvenientService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class HomeAdminApi {

    @Autowired
    OrderService orderService;

    @Autowired
    ConvenientService convenientService;

    @RequestMapping("/api/char")
    public CharIn chars(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        simpleDateFormat.applyPattern("YYYY");
        int year = Integer.parseInt(simpleDateFormat.format(new Date()));

        int months[] = new int[12];
        List<MoneyMonth> moneyMonth = orderService.moneyMonthYear(year);

        for (int i = 0; i < moneyMonth.size(); i++) {
            months[moneyMonth.get(i).getMonth()-1] = (int) moneyMonth.get(i).getMoney();
        }

        int countMonths[] = new int[12];
        List<CountMonth> countMonth = orderService.countMonthYear(year);
        for (int i = 0; i < countMonth.size(); i++) {
            countMonths[countMonth.get(i).getMonth()-1] = (int) countMonth.get(i).getCountAmount();
        }

        int moneyYear[] =new int[]{18000,20000,16000};
        int orderStatus[] =new int[]{18,200,10,3};

        CharIn charin =new CharIn();
        charin.setCharMonth(months);
        charin.setCountMonth(countMonths);
        charin.setCharYear(moneyYear);
        charin.setOrderStatus(orderStatus);

        return  charin;
    }

    @RequestMapping("/api/home")
    public Statistical in() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        simpleDateFormat.applyPattern("MM");
        int month = Integer.parseInt(simpleDateFormat.format(new Date()));

        simpleDateFormat.applyPattern("YYYY");
        int year = Integer.parseInt(simpleDateFormat.format(new Date()));

        Statistical statistical  = new Statistical();

//      month
        int sumPriceMonth =0;
        int lastSumPriceMonth=0;
        try {
            sumPriceMonth = orderService.sumPriceMonth(month);
            if(month != 1){
                lastSumPriceMonth = orderService.sumPriceMonth(month-1);
            }
        }catch (Exception e){
            sumPriceMonth = 0;
        }

        Fluctuation fMonth = convenientService.fluctuation(sumPriceMonth,lastSumPriceMonth);
        fMonth.setPresent(month);
        statistical.setMonth(fMonth);

//      sumCountMonth
        int sumCountMonth = orderService.sumCountMonth(month);
        int lastSumCountMoth =0;
        if(lastSumCountMoth != 1) {
            lastSumCountMoth = orderService.sumCountMonth(month - 1);
        }
        Fluctuation fCountMonth= convenientService.fluctuation(sumCountMonth,lastSumCountMoth);
        statistical.setCountpricemonth(fCountMonth);


//      sumPriceYear
        int sumPriceYear = orderService.sumPriceYear(year);
        int lastsumPriceYear =0;
        try {
            lastsumPriceYear = orderService.sumPriceYear(year-1);
        } catch (Exception e){}
        Fluctuation fyear= convenientService.fluctuation(sumPriceYear,lastsumPriceYear);
        fyear.setPresent(year);
        statistical.setYear(fyear);

        return statistical;

    }

}
