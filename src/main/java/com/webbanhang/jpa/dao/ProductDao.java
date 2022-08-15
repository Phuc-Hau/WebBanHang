package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
