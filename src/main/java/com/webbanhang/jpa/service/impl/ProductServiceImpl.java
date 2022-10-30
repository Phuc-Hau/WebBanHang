package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.ProductDao;
import com.webbanhang.jpa.model.Product;
import com.webbanhang.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean existsById(Integer id) {
        return ProductDao.existsById(id);
    }
}
