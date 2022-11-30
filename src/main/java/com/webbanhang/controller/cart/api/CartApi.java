package com.webbanhang.controller.cart.api;

import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.*;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class CartApi {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	OrderService orderService;

	@Autowired
	UsersService userService;

	@Autowired
	ProductService productService;

	@Autowired
	CutomerService cutomerService;

	List<OrderDetail> orderDetailTym;

	@GetMapping("/list")
	public List<OrderDetail> cart(HttpServletRequest request) {
		String username = request.getRemoteUser();
		Users user =userService.findByUsername(username);
		List<OrderDetail> list = orderDetailService.findAllUsername(user.getCutomer().getId());
		return list;
	}
	
	@GetMapping("/cart/{p}/{id}")
	public void cart (@PathVariable("p")String p,@PathVariable("id") int id) {
		try {
		    OrderDetail orderDetail	= orderDetailService.findById(id);
		    if(p.equals("plus")) {
		    	orderDetail.setQuantity(orderDetail.getQuantity()+1);
		    }else if(p.equals("pre") && orderDetail.getQuantity()>0) {
		    	orderDetail.setQuantity(orderDetail.getQuantity()-1);
		    }
		    orderDetailService.create(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@PostMapping("/cart/delete/{id}")
	public void deleteCart(@PathVariable("id") int id) {
		OrderDetail orderDetail = orderDetailService.findById(id);
		orderDetailService.delete(orderDetail);
	}



	@PostMapping("/newcart")
	public JSONObject newCart(@RequestBody JSONObject json, HttpServletRequest request) {

		JSONObject obj = new JSONObject();
		int id = Integer.parseInt(String.valueOf(json.get("id")));
		int quantity = Integer.parseInt(String.valueOf(json.get("quantity")));

		Product product = productService.findById(id);
		int idCutomer =userService.findByUsernameGetIdCutomer(request.getRemoteUser());

		Order order = orderService.findIdCutomer(idCutomer);

		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setProduct(product);
		orderDetail.setQuantity(quantity);

		try {
			if(order != null) {
				OrderDetail orderDetailTym = orderDetailService.findIdProduct(product.getId(),idCutomer);

				if(orderDetailTym == null) {
					orderDetail.setOrder(order);
					orderDetailService.create(orderDetail);
				}else {
					orderDetailTym.setQuantity(orderDetailTym.getQuantity()+quantity);
					orderDetailService.create(orderDetailTym);
				}

			}else {
				Order order2 = new Order();
				order2.setStatus(0);
				order2.setCutomer(cutomerService.findById(idCutomer));
				orderService.create(order2);
				orderDetail.setOrder(order2);
				orderDetailService.create(orderDetail);
			}
			obj.put("status",true);
			obj.put("message", "Thêm sản phẩm "+product.getName()+" vào giỏ hàng thành công!");
		} catch (Exception e) {
			obj.put("status",false);
			obj.put("message", "Thêm sản phẩm "+product.getName()+" vào giỏ hàng thất bại!");
		}
		return obj;
	}

	@PostMapping("/cart/newpay")
	public void orderDetailTym(@RequestBody List<OrderDetail> orderDetail) {
		orderDetailTym= orderDetail;
	}

	@PostMapping("/order/confirm")
	public List<OrderDetail> confirm() {
		return orderDetailTym;
	}

	@PostMapping("/cart/pay/{pvc}")
	public JSONObject Pay(@PathVariable("pvc") int pvc,HttpServletRequest request) {

		JSONObject obj = new JSONObject();
		int idCutomer =userService.findByUsernameGetIdCutomer(request.getRemoteUser());
		List<OrderDetail> orderDetail =orderDetailTym;

		Order order2 = new Order();
		order2.setStatus(1);
		order2.setCutomer(cutomerService.findById(idCutomer));

		try{

			orderService.create(order2);
			int totalmoney=0;
			for(int i=0 ; i<orderDetail.size();i++){
				totalmoney += orderDetail.get(i).getQuantity() * orderDetail.get(i).getProduct().getPrice()*(1-orderDetail.get(i).getProduct().getSale());
				orderDetail.get(i).setOrder(order2);
			}
			if(pvc==1){
				totalmoney += 20000;
			}
			if(pvc==2){
				totalmoney += 30000;
			}
			order2.setTotalmoney(totalmoney);

			orderDetailService.listCreate(orderDetail);
			orderDetailTym = null;
			obj.put("status",true);
			obj.put("message", "Đặt hàng hành công!");
		} catch (Exception e){
			obj.put("status",true);
			obj.put("message", "Đặt hàng thất bại!");
		}
		return obj;
	}


}
