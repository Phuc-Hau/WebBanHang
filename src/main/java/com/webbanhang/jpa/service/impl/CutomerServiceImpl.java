package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.CutomerDao;
import com.webbanhang.jpa.model.Cutomer;
import com.webbanhang.jpa.service.CutomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CutomerServiceImpl implements CutomerService {
    @Autowired
    CutomerDao cutomerDao;

    @Override
    public List<Cutomer> findAll() {
        return cutomerDao.findAll();
    }

    @Override
    public Cutomer findById(Integer id) {
        return cutomerDao.findById(id).get();
    }

    @Override
    public Cutomer create(Cutomer entity) {
        return cutomerDao.save(entity);
    }

    @Override
    public Cutomer update(Cutomer entity) {
        return cutomerDao.save(entity);
    }

    @Override
    public int getIdFinal() {
        return cutomerDao.getIdFinal();
    }

    @Override
    public boolean existsById(Integer id) {
        return cutomerDao.existsById(id);
    }
}
