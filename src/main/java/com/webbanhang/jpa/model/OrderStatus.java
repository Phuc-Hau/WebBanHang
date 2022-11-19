package com.webbanhang.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "orderstatus")
@Entity
public class OrderStatus {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name="Status")
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}