package com.webbanhang.controller.cart;

import com.webbanhang.jpa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.webbanhang.jpa.dao.CutomerDao;
import com.webbanhang.jpa.dao.OrderDao;
import com.webbanhang.jpa.dao.OrderDetailDao;
import com.webbanhang.jpa.dao.ProductDao;
import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.jpa.model.Order;
import com.webbanhang.jpa.model.OrderDetail;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class CartController {
	
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@Autowired
	OrderDao orderDao; 

	@Autowired
	ProductDao productDao;

	@Autowired
	UserDao userDao;

	@Autowired
	CutomerDao cutomerDao;

	@GetMapping("/cart")
	public String cart() {
		return "cart/cart";
	}


	@PostMapping("/newcart")
	public String newCart(@RequestParam("quantity") int quantity,@RequestParam("id") int id,HttpServletRequest request) {

		Product product = productDao.getById(id);

		int idCutomer =userDao.findByUsernameGetIdCutomer(request.getRemoteUser());
		
		Order order = orderDao.findIdCutomer(idCutomer);

		OrderDetail orderDetail = new OrderDetail();

		orderDetail.setProduct(product);
		orderDetail.setQuantity(quantity);

		try {
			if(order != null) {
				OrderDetail orderDetailTym = orderDetailDao.findIdProduct(product.getId(),idCutomer);

				if(orderDetailTym == null) {
					orderDetail.setOrder(order);
					orderDetailDao.save(orderDetail);
				}else {
					orderDetailTym.setQuantity(orderDetailTym.getQuantity()+quantity);
					orderDetailDao.save(orderDetailTym);
				}

			}else {
				Order order2 = new Order();

				order2.setStatus(false);
				order2.setOrderDetails(null);
				order2.setCutomer(cutomerDao.getById(idCutomer));

				orderDao.save(order2);

				orderDetail.setOrder(order2);
				orderDetailDao.save(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/product/sanpham/"+id;
	}

}
