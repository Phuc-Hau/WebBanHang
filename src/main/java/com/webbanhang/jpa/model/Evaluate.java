package com.webbanhang.jpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "evaluate")
@Entity
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "Product_id")
    private int product_id;

    @JoinColumn(name = "Orders_id")
    private int orders_id;

    @Column(name = "Comment", length = 45)
    private String comment;

    @Column(name = "Date")
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "Cutomer_id")
    private Cutomer cutomer;

    @Column(name = "foot_quality")
    private Integer footQuality;

    public Integer getFootQuality() {
        return footQuality;
    }

    public void setFootQuality(Integer footQuality) {
        this.footQuality = footQuality;
    }

    public Cutomer getCutomer() {
        return cutomer;
    }

    public void setCutomer(Cutomer cutomer) {
        this.cutomer = cutomer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}