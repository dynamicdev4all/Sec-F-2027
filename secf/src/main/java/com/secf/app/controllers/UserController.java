package com.secf.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secf.app.models.User;

@RestController
public class UserController {
//Create (Register), Read, Update and Delete --> CRUD
	
	Map<Integer, User> db = new HashMap<Integer, User>();
	int current = 1;
	//Create
	@PostMapping("/user/register")
	public String createNewUser(@RequestBody User newUser) {
		try {
			db.put(current , newUser);
			current ++;
			return "Register Success";
		} catch (Exception e) {
			return "Registration Failed";
		}
	}
	
	//Read All
	@GetMapping("/user/show_all")
	public ArrayList<User> showAll() {
		ArrayList<User> list = new ArrayList<User>();
		list.addAll(db.values()); // here we are storing the values for the map into an arraylist
		return list;
	}
	
	//Read One
	public User showOne(int uid) {
		return db.get(uid);
	}
}
