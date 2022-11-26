package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluateDao extends JpaRepository<Evaluate, Integer> {
    @Query("SELECT o FROM Evaluate o where o.product.id= ?1")
    List<Evaluate> getEvaluateByProduct(int idProduct);
}