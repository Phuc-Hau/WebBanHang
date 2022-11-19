package com.webbanhang.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanhang.jpa.model.GroupProduct;
import org.springframework.data.jpa.repository.Query;

public interface GroupProductDao extends JpaRepository<GroupProduct, Integer>{

}
