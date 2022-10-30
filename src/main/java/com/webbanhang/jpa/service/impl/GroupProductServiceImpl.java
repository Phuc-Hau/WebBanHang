package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.GroupProductDao;
import com.webbanhang.jpa.model.GroupProduct;
import com.webbanhang.jpa.service.GroupProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupProductServiceImpl implements GroupProductService {
    @Autowired
    GroupProductDao GroupProductDao;


    @Override
    public List<GroupProduct> findAll() {
        return GroupProductDao.findAll();
    }

    @Override
    public GroupProduct findById(Integer id) {
        return GroupProductDao.findById(id).get();
    }

    @Override
    public GroupProduct create(GroupProduct entity) {
        return GroupProductDao.save(entity);
    }

    @Override
    public GroupProduct update(GroupProduct entity) {
        return GroupProductDao.save(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return GroupProductDao.existsById(id);
    }
}
