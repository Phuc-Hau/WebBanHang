package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImgDao extends JpaRepository<Img, Integer> {

    @Query("SELECT o FROM Img o where o.product.id =?1 and o.id not in  ?2 ")
    List<Img> notIn (int idProduct, int[] i);

}