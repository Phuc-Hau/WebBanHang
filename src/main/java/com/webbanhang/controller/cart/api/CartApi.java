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
import java.util.ArrayList;
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

	List<OrderDetail> orderDetailTym = new ArrayList<>();

	@PostMapping("/cart/newpay")
	public void orderDetailTym(@RequestBody List<OrderDetail> orderDetail) {
		orderDetailTym = orderDetail;
	}

	@PostMapping("/cart/buynow")
	public JSONObject productOrderDetailTym(@RequestBody JSONObject json) {

		JSONObject obj = new JSONObject();
		int id = Integer.parseInt(String.valueOf(json.get("id")));
		int quantity = Integer.parseInt(String.valueOf(json.get("quantity")));

		Product product = productService.findById(id);

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setProduct(product);
		orderDetail.setQuantity(quantity);

		orderDetailTym.add(orderDetail);
		try {
			obj.put("status",true);
		} catch (Exception e){
			obj.put("status",false);
			obj.put("message", "Mua ngay thất bại!");
		}
		return obj;
	}


	@PostMapping("/order/confirm")
	public List<OrderDetail> confirm() {
		return orderDetailTym;
	}

	@PostMapping("/huydh")
	public void huy(){
		orderDetailTym = null;
	}

	@PostMapping("/cart/pay")
	public JSONObject Pay(@RequestBody JSONObject jsonbody,HttpServletRequest request) {

		JSONObject obj = new JSONObject();

		int idCutomer =userService.findByUsernameGetIdCutomer(request.getRemoteUser());
		List<OrderDetail> orderDetail =orderDetailTym;

		Order order = new Order();
		order.setStatus(1);
		order.setAddress((String) jsonbody.get("address"));
		order.setDistrict((String) jsonbody.get("district"));
		order.setProcvince((String) jsonbody.get("procvince"));
		order.setReceiver((String) jsonbody.get("receiver"));
		order.setWard((String) jsonbody.get("ward"));
		order.setTel((String) jsonbody.get("tel"));

		order.setCutomer(cutomerService.findById(idCutomer));
		order.setDeliveryCharges((Integer) jsonbody.get("deliveryCharges"));

		try{
			orderService.create(order);
			int totalmoney=0;
			for(int i=0 ; i<orderDetail.size();i++){
				totalmoney += orderDetail.get(i).getQuantity() * orderDetail.get(i).getProduct().getPrice()*(1-orderDetail.get(i).getProduct().getSale());
				orderDetail.get(i).setOrder(order);
			}

			order.setTotalmoney(totalmoney);

			orderDetailService.listCreate(orderDetail);

			productService.UpdateAmoutPay(orderDetail);

			orderDetailTym = null;
			obj.put("status",true);
			obj.put("message", "Đặt hàng hành công!");
		} catch (Exception e){
			obj.put("status",false);
			obj.put("message", "Đặt hàng thất bại!");
		}
		return obj;
	}


}
