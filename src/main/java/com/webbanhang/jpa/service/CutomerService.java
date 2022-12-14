package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.Cutomer;

import java.util.List;

public interface CutomerService {
    List<Cutomer> findAll();
    Cutomer findById(Integer id);
    Cutomer create(Cutomer entity);
    Cutomer update(Cutomer entity);
    boolean existsById(Integer id);
}
