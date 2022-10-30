package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.History;

import java.util.List;

public interface HistoryService {


    List<History> findAll();
    History findById(Integer id);
    History create(History entity);
    History update(History entity);
    
    boolean existsById(Integer id);

}
