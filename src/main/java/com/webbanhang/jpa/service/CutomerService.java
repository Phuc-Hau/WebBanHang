package com.webbanhang.jpa.service;

import com.webbanhang.jpa.dao.CutomerDao;
import com.webbanhang.jpa.model.Cutomer;

import java.util.List;

public interface CutomerService {


    List<Cutomer> findAll();
    Cutomer findById(Integer id);
    Cutomer create(Cutomer entity);
    Cutomer update(Cutomer entity);
    int getIdFinal();
    boolean existsById(Integer id);

}
