package com.webbanhang.jpa.model;



public class EditUserAdmin {

	private int iduser;
	private String email;
	private String password;
	private String roles;
	private boolean status;
	private String username;
	private String img;
	
	private int idcutomer;
	private String address;
	private String birthday;
	private String name;
	private String provinces;
	private String tel;
	private String district;
	private String sex;

	private Users user;
	private Cutomer cutomer;

	public void setUser(Users user) {
		this.user = user;
		this.iduser = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRole();
		this.status = user.isStatus();
		this.username = user.getUsername();
		this.img = user.getImg();
	}

	public void setCutomer(Cutomer cutomer) {
		this.cutomer = cutomer;
		this.idcutomer = cutomer.getId();
		this.address = cutomer.getAddress();
		this.birthday = cutomer.getBirthday();
		this.name = cutomer.getName();
		this.provinces = cutomer.getProcvince();
		this.tel = cutomer.getTel();
		this.district = cutomer.getDistrict();
		this.sex = cutomer.getSex();
	}

	public Users getUser() {
		Users user = new Users();
		user.setId(iduser);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(roles);
		user.setStatus(status);
		user.setUsername(username);
		user.setImg(img);
		return user;
	}

	public Cutomer getCutomer() {
		Cutomer cutomer = new Cutomer();
		cutomer.setId(idcutomer);
		cutomer.setAddress(address);
		cutomer.setBirthday(birthday);
		cutomer.setName(name);
		cutomer.setProcvince(provinces);
		cutomer.setTel(tel);
		cutomer.setDistrict(district);
		cutomer.setSex(sex);
		return cutomer;
	}


	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getIdcutomer() {
		return idcutomer;
	}

	public void setIdcutomer(int idcutomer) {
		this.idcutomer = idcutomer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinces() {
		return provinces;
	}

	public void setProvinces(String provinces) {
		this.provinces = provinces;
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
}
