package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.GroupProduct;
import com.webbanhang.jpa.model.Img;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.GroupProductService;
import com.webbanhang.jpa.service.ImgService;
import com.webbanhang.jpa.service.ProductService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class ProductAdminApi {
    @Autowired
    ProductService productService;

    @Autowired
    GroupProductService groupProductService;

    @Autowired
    ImgService imgService;

    @RequestMapping("/groupproduct")
    public List<GroupProduct> adminGroupProductSearch() {
        return groupProductService.findAll();
    }

    @RequestMapping("/productlist")
    public List<Product> adminProductList() {
        return productService.findAll();
    }

    @RequestMapping("/product/edit/{id}")
    public Product adminEditProduct(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @PostMapping("/product/Update")
    public JSONObject adminUpdateProduct(@RequestBody Product product) {
        JSONObject obj = new JSONObject();
        try {
            productService.update(product);
            obj.put("status",true);
            obj.put("message", "Cập nhật Sản Phẩm "+product.getName()+" Thành công!");
        }catch (Exception e){
            obj.put("status",false);
            obj.put("message", "Cập nhật Sản Phẩm "+product.getName()+" Thành công!");
        }
        return obj;
    }

    @PostMapping("/product/new")
    public JSONObject adminNewProduct(@RequestBody Product product) {
        JSONObject obj = new JSONObject();
        try {
            productService.create(product);
            obj.put("status",true);
            obj.put("message", "Thêm Sản Phẩm "+product.getName()+" Thành công!");
        }catch (Exception e){
            obj.put("status",false);
            obj.put("message", "Thêm Sản Phẩm "+product.getName()+" Thành công!");
        }
        return obj;
    }
}
