package com.usermanagement.model;

public class Users {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String itemno;
	

	public Users() {
		super();
		
	}


	public Users(int id,String name,String email,String phone,String itemno) {
		this(name,email,phone,itemno);
		this.id = id;
		
	}
	

	public Users(String name, String email, String phone, String itemno) {
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.itemno = itemno;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", itemno=" + itemno
				+ "]";
	}


	
	
	
	

}
