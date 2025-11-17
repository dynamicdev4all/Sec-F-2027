package com.app.models;

public class UserModel {
	private static String _firstName;
	private static String _lastName;
	private static int _phone;
	private static String _userEmail;
	private static String _userPassword;
	
	public UserModel(String firstName, String lastName, int phone, String userEmail, String userPassword){
		_firstName = firstName;
		_lastName = lastName;
		_phone = phone; 
		_userEmail = userEmail;
		_userPassword = userPassword;
	}
	
	
	public static String getFirstName() {
		return _firstName;
	}
	
	public static String getLastName() {
		return _lastName;
	}
	
	public static int getPhone() {
		return _phone;
	}
	
	public static String getUserEmail() {
		return _userEmail;
	}
	
	public static String getUserPassword() {
		return _userPassword;
	}
	
}
