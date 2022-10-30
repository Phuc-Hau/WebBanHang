package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.HistoryDao;
import com.webbanhang.jpa.model.History;
import com.webbanhang.jpa.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryDao HistoryDao;


    @Override
    public List<History> findAll() {
        return HistoryDao.findAll();
    }

    @Override
    public History findById(Integer id) {
        return HistoryDao.findById(id).get();
    }

    @Override
    public History create(History entity) {
        return HistoryDao.save(entity);
    }

    @Override
    public History update(History entity) {
        return HistoryDao.save(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return HistoryDao.existsById(id);
    }
}
