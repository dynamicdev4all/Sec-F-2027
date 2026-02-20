package com.secf.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.secf.app.models.User;


@Repository
public class UserRepository {
	Map<Integer, User> db = new HashMap<Integer, User>();
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
	public User showOne(int uid) {
		return db.get(uid);
	}
	public void userLogin() {
		
	}
	public void updateUser() {
		
	}
}
