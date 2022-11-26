package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.EvaluateDao;
import com.webbanhang.jpa.model.Evaluate;
import com.webbanhang.jpa.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    EvaluateDao evaluateDao;

    @Override
    public List<Evaluate> findAll() {
        return evaluateDao.findAll();
    }

    @Override
    public Evaluate findById(Integer id) {
        return evaluateDao.findById(id).get();
    }

    @Override
    public Evaluate create(Evaluate entity) {
        return evaluateDao.save(entity);
    }

    @Override
    public Evaluate update(Evaluate entity) {
        return evaluateDao.save(entity);
    }

    @Override
    public List<Evaluate> getEvaluateByProduct(int idProduct) {
        return evaluateDao.getEvaluateByProduct(idProduct);
    }

    @Override
    public boolean existsById(Integer id) {
        return evaluateDao.existsById(id);
    }
}
