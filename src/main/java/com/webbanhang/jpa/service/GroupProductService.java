package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.GroupProduct;

import java.util.List;

public interface GroupProductService {


    List<GroupProduct> findAll();
    GroupProduct findById(Integer id);
    GroupProduct create(GroupProduct entity);
    GroupProduct update(GroupProduct entity);
    
    boolean existsById(Integer id);

}
