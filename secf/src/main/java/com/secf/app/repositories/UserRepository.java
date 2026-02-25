package com.secf.app.repositories;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.secf.app.models.User;


@Repository
public class UserRepository {
	Map<Integer, User> db = new HashMap<Integer, User>();
	
	Map<String, String> service = new HashMap<String, String>();
	
	
	int current = 1;
	
	public User userRegister(User newUser) {
		try {
			db.put(current , newUser);
			current ++;
			return newUser;
		} catch (Exception e) {
			return null;
		}
	}
	public ArrayList<User> showAll() {
		ArrayList<User> list = new ArrayList<User>();
		list.addAll(db.values()); // here we are storing the values for the map into an arraylist
		return list;
	}
	
	public ArrayList<String> showAllServices() {
		service.put("ride_book", "this is used to book rides");
		service.put("ride_cancel", "this is used to cancel rides");
		service.put("ride_update", "this is used to update active rides");
		service.put("ride_scheduling", "this is used to schedule future rides");
		service.put("ride_abort", "this is used to abort rides");
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(service.keySet());
		return list;
	}
	public User showOne(int uid) {
		return db.get(uid);
	}
	public User userLogin(int id, String email, String pass) {
		User user = showOne(id);
		if(user != null) {
			if(user.getEmail().equals(email) && user.getPassword().equals(pass)) {
				return user;
			}
			return null;
		}
		return null;
	}
	public void updateUser() {
		
	}
}
