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

import java.sql.SQLException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class ProductAdminApi {
    @Autowired
    ProductService productService;

    @Autowired
    GroupProductService groupProductService;


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
            obj.put("message", "Cập nhật Sản Phẩm "+product.getName()+" Thất bại!");
        }
        return obj;
    }

    @PostMapping("/product/new")
    public JSONObject adminNewProduct(@RequestBody Product product) {
        JSONObject obj = new JSONObject();
        if(product.getName()!= null && product.getName().replaceAll(" ", "") != ""){
            try {
                product.setStatus(true);
                productService.create(product);
                obj.put("status",true);
                obj.put("message", "Thêm Sản Phẩm "+product.getName()+" Thành công!");
                Thread.sleep(1000);
                obj.put("id", productService.getLastId());
            }catch (Exception e  ){
                e.getCause();
                obj.put("status",false);
                obj.put("message", "Thêm Sản Phẩm "+product.getName()+" Thất bại! chưa chọn Group sản phẩm");
            }
        }else{
            obj.put("status",false);
            obj.put("message", "Thêm Sản Phẩm Thất bại không thể thêm sản phẩm không tên");
        }
        return obj;
    }
}
