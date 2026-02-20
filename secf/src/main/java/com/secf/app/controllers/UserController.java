package com.secf.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secf.app.models.User;
import com.secf.app.services.UserService;

@RestController
public class UserController {
//Create (Register), Read, Update and Delete --> CRUD
	
	@Autowired
	UserService service;
	
	//Create
	@PostMapping("/user/register")
	public String createNewUser(@RequestBody User newUser) {
		User user = service.registerService(newUser);
		if(user != null) {
			return "Registration Successful.";
		}
		return "Registration Failed.";
	}
	
	//Read All
	@GetMapping("/user/show_all")
	public ArrayList<User> showAll() {
		return service.showAllService();
	}
	
	
	
	//Read One
	@GetMapping("/user/show_one/{uid}")
	public User showOne(@PathVariable int uid) {
		return service.showOneService(uid);
	}
}
