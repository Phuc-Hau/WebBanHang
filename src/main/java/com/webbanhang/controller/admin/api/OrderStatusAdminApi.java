package com.webbanhang.controller.admin.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.webbanhang.jpa.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.OrderStatus;
import com.webbanhang.jpa.service.OrderDetailService;
import com.webbanhang.jpa.service.OrderService;
import com.webbanhang.jpa.service.OrderStatusService;
import com.webbanhang.jpa.service.ProductService;

import net.minidev.json.JSONObject;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api")
public class OrderStatusAdminApi {
	@Autowired
    OrderStatusService orderStatusService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping("/listorderstatus")
    public List<Order> cart(HttpServletRequest request) {

        List<Order> list = orderService.findAll();

        return list;
    }

   
    
    @GetMapping("/listordersDetail")
    public List<OrderDetail> listordersDetail(HttpServletRequest request ) {

        List<OrderDetail> list = orderDetailService.findAll();

        return list;
    }
    
    @PostMapping("/orderstatusChange/{id}/{sta}")
    public JSONObject updateOrderStatus(HttpServletRequest request , @PathVariable ("id") int id, @PathVariable ("sta") int sta) {
    	JSONObject obj = new JSONObject();
    	Order order = orderService.findById(id);
    	order.setStatus(sta);
    	try {
    		orderService.update(order);
            obj.put("status",true);
            obj.put("message", "Cập nhật trạng thái thành công!");
		} catch (Exception e) {
            obj.put("status",false);
            obj.put("message", "Cập nhật trạng thái thất bại!");
		}

        return obj;
    }
    


    @GetMapping("OrderStatus")
    public List<OrderStatus> status(){
        return orderStatusService.findAll();
    }

    @PostMapping("/OrderHuy/{id}")
    public JSONObject OrderHuy(@PathVariable("id") int id){
        JSONObject obj = new JSONObject();
        Order order = orderService.findById(id);
        order.setStatus(5);
        try {
            orderService.update(order);
            obj.put("status",true);
            obj.put("message", "Hủy thành công!");
        }catch (Exception e){
            obj.put("status",false);
            obj.put("message", "Hủy thất bại!");
        }
        return obj;
    }
}
