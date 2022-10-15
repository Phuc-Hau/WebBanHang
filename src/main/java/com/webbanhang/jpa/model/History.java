package com.webbanhang.jpa.model;

import javax.persistence.*;

@Table(name = "history", indexes = {
        @Index(name = "id_idx", columnList = "Ordersid")
})
@Entity
public class History {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Ordersid")
    private Order ordersid;

    @Column(name = "Statusid", length = 45)
    private String statusid;

    @Column(name = "Note")
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public Order getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Order ordersid) {
        this.ordersid = ordersid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}