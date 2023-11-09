package com.medicine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	private String loginid;
	private String password;
	
	public Admin() {
	}
	
	public Admin(String loginid, String password) {
		this.loginid = loginid;
		this.password = password;
	}

	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
