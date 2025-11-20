package com.app.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTUtil {
	
	static String SECRET = "thisistopsecretcode";
	//This is encryption using SHA 256 (Secure Hash Algorithm with 256 bytes)
	// ref - bcrypt
	static Algorithm a = Algorithm.HMAC256(SECRET);
	static long currentTime = new Date().getTime(); // this stores current date and time
	static long expireDuration = 10 * 60 * 1000; // this is 10 mins
	static Date date = new Date(currentTime + expireDuration);
//	static String [] name = {"firstName", "lastName"};
	//this function creates a JWT token.
	public static void createJWT(String email) {
		String token = JWT.create()
		.withSubject(email)
//		.withArrayClaim("name", name)
//		.withClaim("gender", "male")
		.withExpiresAt(date)
		.sign(a);
		System.out.println(token);
	}
	
	//this function verifies the JWT token.
	public static void verifyJWT() {
		
	}
	
	public static void main(String a[]) {
		createJWT("piebytwo014@gmail.com");
	}
}
