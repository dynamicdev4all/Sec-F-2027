package com.secf.app.DTOs;

public class UserDataDTO {
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

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	int id;
	String name;
	String email;
	String upi;
	boolean status;
	
	public UserDataDTO(int id, String name, String email, String upi, boolean status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.upi = upi;
		this.status = status;
	}
}
