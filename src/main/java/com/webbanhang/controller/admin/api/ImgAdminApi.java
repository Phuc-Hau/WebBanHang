package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.Img;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.ImgService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class ImgAdminApi {
    @Autowired
    ImgService imgService;

    @PostMapping("/img/Update/{id}")
    public JSONObject adminUpdateProduct(@RequestBody List<Img> img,@PathVariable("id") int id) {
        JSONObject obj = new JSONObject();
        Product product = new Product();
        product.setId(id);
        for (int i = 0; i < img.size(); i++) {
            img.get(i).setProduct(product);
        }
        try {
            imgService.updateAll(img);
            obj.put("status",true);
        }catch (Exception e){
            obj.put("status",false);
        }
        return obj;
    }
}
