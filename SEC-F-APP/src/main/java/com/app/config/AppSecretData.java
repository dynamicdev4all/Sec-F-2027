package com.app.config;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppSecretData {
	
	public static void main(String a []) {
		System.out.println("this is 0: "+ getDateTime(0));
		System.out.println("this is 1: "+ getDateTime(1));
		System.out.println("this is 2: "+ getDateTime(2));
		System.out.println("this is 3: "+ getDateTime(3));
		System.out.println(getNumber());
		System.out.println(ERROR_LOG("The Account is not Verified"));
		String red ="\u001B[32m";
		System.out.println(red +"Success");
		
	}
	
	public static Locale setLocale(String lang, String country) {
//		Locale locale = new Locale(lang, country); //this is the deprecated version
		Locale locale = Locale.of(lang, country); //this is the new version
		return locale;
	}
	
	public static String loadAppSecrets(String key, String lang, String country) {
		ResourceBundle rb = ResourceBundle.getBundle("appData", setLocale(lang, country));
		return rb.getString(key);
	}
	
	
	public static String getDateTime(int style) {
		Date dt = new Date();
		DateFormat dtf = DateFormat.getDateInstance(style, Locale.of("hi", "IN"));
		return dtf.format(dt);
	}
	
	public static String getNumber() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("fr", "FR"));
		return nf.format(100000.0);
	}
	
	public static String ERROR_LOG(String msg) {
		final String ERROR_RED = "\u001B[31m";
		return ERROR_RED + "logs :"+ getDateTime(3) + " type : "+ "ERR "+msg; 
	}
	
//	public static String appLogs(String type, String msg) {
////		return  getDateTime() + " " + type + " " + msg;
//	}
	
}
