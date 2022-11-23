package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>{
    @Query("SELECT o.id FROM Product o order by o.id desc" )
    List<Integer> getLastId();
}
