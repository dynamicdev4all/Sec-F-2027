package com.app.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	
	static String SECRET = "thisistopsecretcode";
	//This is encryption using SHA 256 (Secure Hash Algorithm with 256 bytes)
	// ref - bcrypt
	static Algorithm a = Algorithm.HMAC256(SECRET);
	
	//this variable stores current date and current time
	static Date currentDateTime = new Date();
	static long currentTime = currentDateTime.getTime(); // this stores current date and time
	static long expireDuration = 10 * 60 * 1000; // this is 10 min
	
	// this variable stores expire date and expire time
	static Date expireDateTime = new Date(currentTime + expireDuration);
	
	//this function creates a JWT token.
	public static String createJWT(String email, int OTP, String name, String gender, String phone) {
		String token = JWT.create()
		.withExpiresAt(expireDateTime)
		.withIssuedAt(currentDateTime)
		.withClaim("otp", OTP)
		.withSubject(email)
//		.withClaim("userName", name)
//		.withClaim("gender", gender)
		.withIssuer("SEC-F")
//		.withClaim("phoneNum", phone)
		.sign(a);
		
		return token;
		
	}
	
	//this function verifies the JWT token.
	public static String verifyJWT(String token) {
		try {
			DecodedJWT decode = JWT.require(a)
					.build().verify(token);
			return decode.getSubject();
//			System.out.println("THE TOKEN IS VALID");
//			System.out.println("The token author is " + decode.getIssuer());
//			System.out.println("The email add is " + decode.getSubject());
//			System.out.println("The user name is " + decode.getClaim("userName"));
//			System.out.println("The user gender is " + decode.getClaim("gender"));
//			System.out.println("The user phone is " + decode.getClaim("phoneNum"));
//			System.out.println("The token is created at " + decode.getIssuedAt());
//			System.out.println("The token will expire on " + decode.getExpiresAt());
		} catch (Exception e) {
			System.out.println("THE TOKEN IS EXPIRED, PLEASE RETRY.");
			return "some error occured";
		}
		
	}
	
	public static void main(String a[]) {
//		createJWT("piebytwo014@gmail.com", 123456, "Ayush", "M", "123123");
		
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NjQyMTg4MTIsImlhdCI6MTc2NDIxODIxMiwic3ViIjoicGllYnl0d28wMTRAZ21haWwuY29tIiwidXNlck5hbWUiOiJBeXVzaCIsImdlbmRlciI6Ik0iLCJpc3MiOiJTRUMtRiIsInBob25lTnVtIjoiMTIzMTIzIn0.vC8VHgTtjRHJdnXtonCPHqfwU9J3ppuh-dZ8PUPsb-I";
		verifyJWT(token);
	}
}
