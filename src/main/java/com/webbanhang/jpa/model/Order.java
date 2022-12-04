package com.webbanhang.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Table(name = "orders", indexes = {
        @Index(name = "Customer_id_idx", columnList = "Customer_id"),
        @Index(name = "Status_idx", columnList = "Status")
})
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Cutomer cutomer;

    @Column(name="Totalmoney")
    private double totalmoney;

    @Column(name="Date")
    private Timestamp date = new Timestamp(System.currentTimeMillis());

    @Column(name="Status")
    private int status;

    @Column(name = "Address", length = 100)
    private String address;

    @Column(name = "Procvince", length = 45)
    private String procvince;

    @Column(name = "District", length = 45)
    private String district;

    @Column(name = "Receiver", length = 45)
    private String receiver;

    @Column(name = "Tel", length = 45)
    private String tel;

    @Column(name = "Delivery_charges")
    private Integer deliveryCharges;

    @JsonIgnore
    @OneToMany(mappedBy="order")
    private List<OrderDetail> orderDetails;

    public Integer getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProcvince() {
        return procvince;
    }

    public void setProcvince(String procvince) {
        this.procvince = procvince;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cutomer getCutomer() {
        return cutomer;
    }

    public void setCutomer(Cutomer cutomer) {
        this.cutomer = cutomer;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}