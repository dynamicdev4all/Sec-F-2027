package com.rdec.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class SecretReader {
	
	static Locale getLocale(String lang, String country) {
//		Locale locale = new Locale(lang, country);
		Locale locale = Locale.of(lang, country);
		return locale;
	}
	
	public static String readSecrets(String key, String lang, String country) {
		ResourceBundle rb = ResourceBundle.getBundle("appSecrets", getLocale(lang, country));
		return rb.getString(key);
	}
}
