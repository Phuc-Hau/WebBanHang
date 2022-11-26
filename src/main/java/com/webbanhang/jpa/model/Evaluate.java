package com.webbanhang.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "evaluate", indexes = {
        @Index(name = "idorder_idx", columnList = "Orders_id"),
        @Index(name = "idProduct_idx", columnList = "Product_id")
})
@Entity
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Orders_id")
    private OrderDetail orders;

    @Column(name = "Comment", length = 45)
    private String comment;

    @Column(name = "Foot_Quality")
    private String footQuality;

    @Column(name = "Date")
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFootQuality() {
        return footQuality;
    }

    public void setFootQuality(String footQuality) {
        this.footQuality = footQuality;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderDetail getOrders() {
        return orders;
    }

    public void setOrders(OrderDetail orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}