package com.webbanhang.controller.cart.api;


import com.webbanhang.jpa.model.Evaluate;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.EvaluateService;
import com.webbanhang.jpa.service.UsersService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/evalute")
public class EvaluateApi {

    @Autowired
    EvaluateService evaluateService;

    @Autowired
    UsersService usersService;

    @RequestMapping("getEvaluteProduct/{id}")
    public JSONObject getEvaluate(@PathVariable("id") int id){
        List<Evaluate> list = evaluateService.getEvaluateByProduct(id);
        JSONObject obj = new JSONObject();
        obj.put("evalute",list);

        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            array.add(usersService.imgIdCutomer(list.get(i).getCutomer().getId()));
        }
        obj.put("avatar",array);
        return obj;
    }


    @PostMapping("new")
    public JSONObject newEvaluate(@RequestBody Evaluate evaluate, HttpServletRequest request){
        String username = request.getRemoteUser();

        Users user =usersService.findByUsername(username);
        evaluate.setCutomer(user.getCutomer());

        JSONObject obj = new JSONObject();
        try {
            evaluateService.create(evaluate);
            obj.put("status",true);
            obj.put("message", "Đánh giá Thành công!");
        }catch (Exception e){
            e.printStackTrace();
            obj.put("status",false);
            obj.put("message", "Đánh giá thất bại!");
        }
        return obj;
    }



}
