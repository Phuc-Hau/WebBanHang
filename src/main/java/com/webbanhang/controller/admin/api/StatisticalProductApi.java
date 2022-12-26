package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.Evaluate;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.EvaluateService;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.UsersService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class StatisticalProductApi {
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    EvaluateService evaluateService;

    @Autowired
    UsersService usersService;

    @GetMapping("/StatisticalProduct")
    public List<OrderDetail> StatisticalProduct() {
        return orderDetailService.orderDetailPay();
    }

    @GetMapping("/detailsStatisticalProduct/{id}")
    public JSONObject detailsStatisticalProduct(@PathVariable("id") int id) {
        JSONObject jsonObject = new JSONObject();
        List<OrderDetail> orderDetailList =orderDetailService.orderDetailPay(id);

        jsonObject.put("product",orderDetailList.get(0).getProduct());

        int quantity = orderDetailList.stream().mapToInt(OrderDetail::getQuantity).sum();
        jsonObject.put("quantity",quantity);

        List<Integer> idCutomer = new ArrayList<>();
        for (int i = 0; i < orderDetailList.size(); i++) {
           idCutomer.add(orderDetailList.get(i).getOrder().getCutomer().getId());
        }

        List<Users> users = usersService.listIdcutomer(idCutomer);
        jsonObject.put("users",users);

        float star = 0;
        List<Evaluate> evaluateList = evaluateService.getEvaluateByProduct(id);
        for (int i = 0; i < evaluateList.size(); i++) {
            star += evaluateList.get(i).getFootQuality();
        }
        if(evaluateList.size() !=0){
            star = star/evaluateList.size();
        }
        jsonObject.put("star",star);
        jsonObject.put("evaluate",evaluateList.size());

        return jsonObject;
    }

}
