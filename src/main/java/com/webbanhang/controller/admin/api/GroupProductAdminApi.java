package com.webbanhang.controller.admin.api;

import com.webbanhang.jpa.model.GroupProduct;
import com.webbanhang.jpa.service.GroupProductService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class GroupProductAdminApi {

    @Autowired
    GroupProductService groupProductService;

    @RequestMapping("/groupproductlist")
    public List<GroupProduct> adminGroupProductList() {
        return groupProductService.findAll();
    }

    @RequestMapping("/groupproduct/edit/{id}")
    public GroupProduct adminEditGroupProduct(@PathVariable("id") int id) {
        return groupProductService.findById(id);
    }
    
    @PostMapping("/groupproduct/Update")
    public JSONObject adminUpdateGroupProduct(@RequestBody GroupProduct groupProduct) {
        JSONObject obj = new JSONObject();
        try {
            groupProductService.update(groupProduct);
            obj.put("status",true);
            obj.put("message", "Cập nhật danh mục sản phẩm "+groupProduct.getName()+" thành công!");
        }catch (Exception e){

            obj.put("status",false);
            obj.put("message", "Cập nhật danh mục sản phẩm "+groupProduct.getName()+" thất bại!");
        }
        return obj;
    }

    @PostMapping("/groupproduct/New")
    public JSONObject adminNewGroupProduct(@RequestBody GroupProduct groupProduct) {
        JSONObject obj = new JSONObject();

        try {
            if(groupProduct.getName() != ""){
                groupProductService.create(groupProduct);
                obj.put("status",true);
                obj.put("message", "Thêm danh mục sản phẩm "+groupProduct.getName()+" thành công!");
            }else{
                obj.put("message", "Không thể thêm mục sản phẩm không tên!");
            }
        }catch (Exception e){
            obj.put("status",false);
            String mess =e.getMessage();
            if(mess.contains("null")){
                obj.put("message", "Không thể thêm mục sản phẩm "+groupProduct.getName()+" !");
            }else if(mess.contains("Name_UNIQUE")) {
                obj.put("message", "danh mục sản phẩm " + groupProduct.getName() + " đã tồn tại!");
            }
        }
        return obj;
    }
}
