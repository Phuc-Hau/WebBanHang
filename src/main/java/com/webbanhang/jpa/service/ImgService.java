package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.Img;

import java.util.List;

public interface ImgService {


    List<Img> findAll();
    Img findById(Integer id);
    Img create(Img entity);
    Img update(Img entity);
    List<Img> updateAll(List<Img> entity);
    boolean existsById(Integer id);

}
