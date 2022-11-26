package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.Evaluate;

import java.util.List;

public interface EvaluateService {

    List<Evaluate> findAll();
    Evaluate findById(Integer id);
    Evaluate create(Evaluate entity);
    Evaluate update(Evaluate entity);
    List<Evaluate> getEvaluateByProduct(int idProduct);
    boolean existsById(Integer id);
}
