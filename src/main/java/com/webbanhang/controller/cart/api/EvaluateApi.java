package com.webbanhang.controller.cart.api;


import com.webbanhang.jpa.model.Evaluate;
import com.webbanhang.jpa.service.EvaluateService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/evalute")
public class EvaluateApi {

    @Autowired
    EvaluateService evaluateService;

    @RequestMapping("getEvaluteProduct/{id}")
    public List<Evaluate> getEvaluate(@PathVariable("id") int id){
        return evaluateService.getEvaluateByProduct(id);
    }


    @PostMapping("new")
    public JSONObject newEvaluate(@RequestBody Evaluate evaluate){
        JSONObject obj = new JSONObject();
        try {
            evaluateService.create(evaluate);
            obj.put("status",true);
            obj.put("message", "Đánh giá Thành công!");
        }catch (Exception e){
            obj.put("status",false);
            obj.put("message", "Đánh giá thất bại!");
        }
        return obj;
    }



}
