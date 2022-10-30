package com.webbanhang.jpa.service.impl;

import com.webbanhang.jpa.dao.UserDao;
import com.webbanhang.jpa.model.Users;
import com.webbanhang.jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UserDao UsersDao;


    @Override
    public List<Users> findAll() {
        return UsersDao.findAll();
    }

    @Override
    public Users findById(Integer id) {
        return UsersDao.findById(id).get();
    }

    @Override
    public Users create(Users entity) {
        return UsersDao.save(entity);
    }

    @Override
    public Users update(Users entity) {
        return UsersDao.save(entity);
    }

    @Override
    public Users findByEmail(String email) {
        return UsersDao.findByEmail(email);
    }

    @Override
    public Users findByUsername(String email) {
        return UsersDao.findByUsername(email);
    }

    @Override
    public Users checkLogin(String username, String password) {
        return UsersDao.checkLogin(username,password);
    }

    @Override
    public int findByUsernameGetIdCutomer(String idUser) {
        return UsersDao.findByUsernameGetIdCutomer(idUser);
    }

    @Override
    public Users findByEmailAndTokeID(String email, String tokeID) {
        return UsersDao.findByEmailAndTokeID(email,tokeID);
    }

    @Override
    public boolean existsById(Integer id) {
        return UsersDao.existsById(id);
    }
}
