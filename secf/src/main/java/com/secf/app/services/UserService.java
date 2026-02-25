package com.secf.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secf.app.models.User;
import com.secf.app.repositories.UserRepository;


@Service
public class UserService {
	
//	UserRepository repo = new UserRepository();
	
	@Autowired
	UserRepository repo;
	
	public User registerService(User newUser) {
		return repo.userRegister(newUser);
	}
	
	public User loginService(int id, String email, String pass) {
		return repo.userLogin(id, email, pass);
	}
	
	public ArrayList<String> showAllService() {
		return repo.showAllServices();
	}
	
	public User showOneService(int uid) {
		return repo.showOne(uid);
	}
}
