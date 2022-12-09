package com.webbanhang.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webbanhang.jpa.model.Cutomer;

public interface CutomerDao extends JpaRepository<Cutomer, Integer>{

}
