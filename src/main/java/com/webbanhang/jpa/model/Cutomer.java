package com.webbanhang.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;
import java.sql.Date;



@Entity
@Table(name="cutomers")
public class Cutomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Address")
	private String address;

	@Column(name="Birthday")
	private Date birthday;

	@Column(name="Name")
	private String name;

	@Column(name="Procvince")
	private String procvince;

	@Column(name="Tel")
	private String tel;

	@Column(name="District")
	private String district;

	@Column(name="Gender")
	private String sex;

	//bi-directional many-to-one association to Order
	@JsonIgnore
	@OneToMany(mappedBy="cutomer")
	private List<Order> orders;

	//bi-directional many-to-one association to User
	@JsonIgnore
	@OneToMany(mappedBy="cutomer")
	private List<Users> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcvince() {
		return procvince;
	}

	public void setProcvince(String procvince) {
		this.procvince = procvince;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	

}