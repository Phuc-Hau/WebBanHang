package com.webbanhang.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webbanhang.jpa.model.Users;

import java.util.List;

public interface UserDao extends JpaRepository<Users, Integer>{

	@Query("SELECT o FROM Users o WHERE o.email = ?1 ")
    Users findByEmail(String email);

	@Query("SELECT o FROM Users o WHERE o.username = ?1 ")
    Users findByUsername(String username);
	
	@Query("SELECT o FROM Users o WHERE o.username = ?1 and o.password = ?2")
    Users checkLogin(String username, String password);

    @Query("SELECT o.cutomer.id FROM Users o WHERE o.username = ?1 ")
    int findByUsernameGetIdCutomer(String idUser);

    @Query("SELECT o FROM Users o WHERE o.email = ?1 and o.token = ?2 ")
    Users findByEmailAndTokeID(String email, String tokeID);

    @Query("SELECT o.img FROM Users o WHERE o.cutomer.id = ?1 ")
    String imgIdCutomer(int idCutomer);

    @Query("SELECT o FROM Users o where o.cutomer.id in ?1")
    List<Users> listIdcutomer(List<Integer> idCutomer);
}
