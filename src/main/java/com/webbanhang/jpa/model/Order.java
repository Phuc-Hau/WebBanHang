package com.webbanhang.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Date")
	private Timestamp date = new Timestamp(System.currentTimeMillis());

	@Column(name="Status")
	private boolean status;

	@Column(name="Totalmoney")
	private double totalmoney;

	//bi-directional many-to-one association to OrderDetail
	@JsonIgnore
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to Cutomer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Cutomer cutomer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	private void setDate() {
		this.date = new Timestamp(System.currentTimeMillis());
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(double totalmoney) {
		setDate();
		this.totalmoney = totalmoney;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Cutomer getCutomer() {
		return cutomer;
	}

	public void setCutomer(Cutomer cutomer) {
		this.cutomer = cutomer;
	}

	

}