package com.app.config;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppSecretData {
	
	public static Locale setLocale(String lang, String country) {
//		Locale locale = new Locale(lang, country); //this is the deprecated version
		Locale locale = Locale.of(lang, country); //this is the new version
		return locale;
	}
	
	public static String loadAppSecrets(String key, String lang, String country) {
		ResourceBundle rb = ResourceBundle.getBundle("appData", setLocale(lang, country));
		return rb.getString(key);
	}
	
	
	public static String getDateTime() {
		Date dt = new Date();
		return dt.toString();
	}
	
	public static String appLogs(String type, String msg) {
		return  getDateTime() + " " + type + " " + msg;
	}
	
}
