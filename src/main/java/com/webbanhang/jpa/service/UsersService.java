package com.webbanhang.jpa.service;

import com.webbanhang.jpa.model.Users;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersService {


    List<Users> findAll();
    Users findById(Integer id);
    Users create(Users entity);
    Users update(Users entity);

    Users findByEmail(String email);
    Users findByUsername(String username);
    Users checkLogin(String username, String password);
    int findByUsernameGetIdCutomer(String idUser);
    Users findByEmailAndTokeID(String email, String tokeID);
    
    boolean existsById(Integer id);

}
