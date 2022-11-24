package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.Img;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.ImgService;
import com.webbanhang.jpa.service.ProductService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class ImgAdminApi {
    @Autowired
    ImgService imgService;
    @Autowired
    ProductService productService;


    @PostMapping("/img/Update/{id}")
    public JSONObject adminUpdateProduct(@RequestBody List<Img> img,@PathVariable("id") int id) {
        JSONObject obj = new JSONObject();
        Product product = new Product();
        product.setId(id);
        List<Img> updateImg = new ArrayList<>();
        try {
            for (int i = 0; i < img.size(); i++) {
                if(img.get(i) != null){
                    img.get(i).setProduct(product);
                    updateImg.add(img.get(i));
                }
            }
            imgService.updateAll(updateImg);
            obj.put("status",true);
        }catch (Exception e){
            e.printStackTrace();
            obj.put("status",false);
            obj.put("message", "Thêm ảnh sản phẩm thất bại!");
        }

        imgService.deleteNotIn(product.getId(), img);
        return obj;
    }
}
