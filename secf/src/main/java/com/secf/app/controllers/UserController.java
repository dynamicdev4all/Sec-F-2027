package com.secf.app.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secf.app.DTOs.AdminDTO;
import com.secf.app.models.User;
import com.secf.app.services.UserService;

@CrossOrigin(origins = "http://localhost:5173/")
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
	
	@PostMapping("/user/login/{id}")
	public ResponseEntity<AdminDTO> login(@PathVariable int id, @RequestBody Map<String, String> userLogin) {
		User user = service.loginService(id, userLogin.get("email"), userLogin.get("pass"));
		if(user == null) {
			AdminDTO aDTO = new AdminDTO( HttpStatus.NOT_FOUND, null , null, false);
			
			return ResponseEntity.ok(aDTO);
		}
		AdminDTO aDTO = new AdminDTO( HttpStatus.OK, "dhfksdf", "jdbfhjdsf", true);
	
		return ResponseEntity.ok(aDTO);
//		return "Login Success";
	}
	
	//Read All
	@GetMapping("/user/show_all")
	public ArrayList<String> showAll() {
		return service.showAllService();
	}
	
	
	
	//Read One
	@GetMapping("/user/show_one/{uid}")
	public User showOne(@PathVariable int uid) {
		return service.showOneService(uid);
	}
}
