package com.secf.app.DTOs;

import org.springframework.http.HttpStatusCode;

import com.secf.app.models.User;

public class UserDTO {
	HttpStatusCode code;
	User user;
	
	public UserDTO(HttpStatusCode code, User user) {
		this.code = code;
		this.user = user;
	}
}
