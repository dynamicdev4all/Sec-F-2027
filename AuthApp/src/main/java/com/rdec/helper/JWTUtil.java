package com.rdec.helper;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTUtil {
	
	static String secret = "my-secret";
	
	static Algorithm signing = Algorithm.HMAC256(secret);

	static void createToken() {
		String token = JWT.create().withIssuer("SEC-F").withIssuedAt(new Date()).withExpiresAt(new Date()).withClaim("email", "user_email").sign(signing);
	}
	
	
	static DecodedJWT verifyToken() {
		JWTVerifier v = JWT.require(signing).withIssuer("SEC-F").build();
		
		return v.verify("token");
	}
	
	
}
