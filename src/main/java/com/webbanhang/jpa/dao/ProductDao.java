package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>{
    @Query("SELECT o.id FROM Product o order by o.id desc" )
    List<Integer> getLastId();

    @Query("Select o from Product o where o.groupProduct.id = ?1 and o.status = 1 Order By Date Desc")
    List<Product> getProductGroup(int idGroupProduct);

    @Query("Select o from Product o where o.status = 1")
    List<Product> findAllStatus();

    @Query("SELECT o FROM Product o where o.sale>0.4 and o.status = 1 order by o.date desc, o.sale desc")
    List<Product> fashSale();


    @Query("SELECT o FROM Product o where o.status = 1 ORDER BY RAND() ")
    List<Product> productSY();

    @Query("select o from Product o where o.groupProduct.id = ?1 and o.status = 1")
    List<Product> productGroup(int idGroup);

    @Query("select o from Product o where ( o.name like ?1 or o.groupProduct.name like ?1 ) and o.status = 1")
    List<Product> searchKeyWord(String keyWord);

    @Query("select o from Product o where  o.status = 1 and o.id = ?1")
    Product getProductById(int idProduct);
}
