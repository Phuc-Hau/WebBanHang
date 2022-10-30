package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgDao extends JpaRepository<Img, Integer> {
}