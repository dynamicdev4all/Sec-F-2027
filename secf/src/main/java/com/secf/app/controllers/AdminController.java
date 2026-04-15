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
import com.secf.app.DTOs.UserDataDTO;
import com.secf.app.models.User;
import com.secf.app.services.UserService;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class AdminController {
//Create (Register), Read, Update and Delete --> CRUD
	
	@Autowired
	UserService service;

	
	@PostMapping("/admin/login/{id}")
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
	@GetMapping("/admin/show_all_users")
	public ArrayList<UserDataDTO> showAll() {
		ArrayList<User> list1= service.showAllUsers();
		ArrayList<UserDataDTO> list2 = new ArrayList<UserDataDTO>();
		for(User u : list1) {
			UserDataDTO uDTO = new UserDataDTO(u.getUid(), u.getName(), u.getEmail(), u.getUpiId(), false);
			list2.add(uDTO);
		}
		return list2;
	}
	
	
	
	//Read One
	@GetMapping("/admin/show_one_user/{uid}")
	public User showOne(@PathVariable int uid) {
		return service.showOneService(uid);
	}
}
