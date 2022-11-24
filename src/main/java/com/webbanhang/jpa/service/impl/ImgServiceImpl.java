package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.ImgDao;
import com.webbanhang.jpa.model.Img;
import com.webbanhang.jpa.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public void delete(Img entity) {
        ImgDao.delete(entity);
    }


    @Override
    public List<Img> updateAll(List<Img> entity){
        return ImgDao.saveAll(entity);
    }


    @Override
    public void deleteNotIn(int idProduct, List<Img> img) {
        int u[] = new int[img.size()];
        for (int i = 0; i < img.size(); i++) {
            if(img.get(i) != null){
                u[i] = img.get(i).getId();
            }
        }
        List<Img> deleteImg = ImgDao.notIn(idProduct,u);
        ImgDao.deleteAll(deleteImg);
    }

    @Override
    public boolean existsById(Integer id) {
        return ImgDao.existsById(id);
    }
}
