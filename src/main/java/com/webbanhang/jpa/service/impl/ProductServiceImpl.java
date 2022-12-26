package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.ProductDao;
import com.webbanhang.jpa.model.OrderDetail;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao ProductDao;


    @Override
    public List<Product> findAll() {
        return ProductDao.findAll();
    }

    @Override
    public List<Product> findAllStatus() {
        return ProductDao.findAllStatus();
    }

    @Override
    public Product findById(Integer id) {
        return ProductDao.findById(id).get();
    }

    @Override
    public Product create(Product entity) {
        return ProductDao.save(entity);
    }

    @Override
    public Product update(Product entity) {
        return ProductDao.save(entity);
    }

    @Override
    public Product getProductById(int idProduct) {
        return ProductDao.getProductById(idProduct);
    }

    @Override
    public int getLastId() {
        return ProductDao.getLastId().get(0);
    }

    @Override
    public boolean existsById(Integer id) {
        return ProductDao.existsById(id);
    }

    @Override
    public List<Product> getProductGroup(int idGroupProduct) {
        return ProductDao.getProductGroup(idGroupProduct);
    }

    @Override
    public void UpdateAmoutPay(List<OrderDetail> orderDetails) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < orderDetails.size(); i++) {
            Product p = orderDetails.get(i).getProduct();
            p.setAmount(orderDetails.get(i).getProduct().getAmount()-orderDetails.get(i).getQuantity());
            productList.add(p);
        }
        try {
            ProductDao.saveAll(productList);
        }catch (Exception e){}
    }

    @Override
    public List<Product> fashSale() {
        return ProductDao.fashSale();
    }

    @Override
    public List<Product> productSY() {
        return ProductDao.productSY();
    }

    @Override
    public List<Product> productGroup(int idGroup) {
        return ProductDao.productGroup(idGroup);
    }

    @Override
    public List<Product> searchKeyWord(String keyWord) {
        return ProductDao.searchKeyWord("%"+keyWord+"%");
    }


}
