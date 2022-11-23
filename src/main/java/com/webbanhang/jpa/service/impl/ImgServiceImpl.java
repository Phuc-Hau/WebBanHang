package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.ImgDao;
import com.webbanhang.jpa.model.Img;
import com.webbanhang.jpa.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    ImgDao ImgDao;


    @Override
    public List<Img> findAll() {
        return ImgDao.findAll();
    }

    @Override
    public Img findById(Integer id) {
        return ImgDao.findById(id).get();
    }

    @Override
    public Img create(Img entity) {
        return ImgDao.save(entity);
    }

    @Override
    public Img update(Img entity) {
        return ImgDao.save(entity);
    }

    @Override
    public List<Img> updateAll(List<Img> entity){
        return ImgDao.saveAll(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return ImgDao.existsById(id);
    }
}
