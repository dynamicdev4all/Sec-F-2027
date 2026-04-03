package com.secf.app.DTOs;

import org.springframework.http.HttpStatusCode;

public class AdminDTO {
	HttpStatusCode code;
	String name;
	String email;
	boolean status;
	public AdminDTO(HttpStatusCode code, String name, String email, boolean status) {
		this.code = code;
		this.name = name;
		this.email = email;
		this.status = status;
	}
}
