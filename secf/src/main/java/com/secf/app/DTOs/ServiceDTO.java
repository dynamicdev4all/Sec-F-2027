package com.secf.app.DTOs;

import org.springframework.http.HttpStatusCode;


public class ServiceDTO {
	HttpStatusCode code;
	String name;
	String desc;
	
	public ServiceDTO(HttpStatusCode code, String name, String desc) {
		this.code = code;
		this.name = name;
		this.desc = desc;
	}
}
