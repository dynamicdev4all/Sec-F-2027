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
	
	public void loginService() {
		
	}
	
	public ArrayList<User> showAllService() {
		return repo.showAll();
	}
	
	public User showOneService(int uid) {
		return repo.showOne(uid);
	}
}
