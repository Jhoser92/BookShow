package com.jsBinary.BookShow.jwtService;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	static final long EXPIRATIONTIME = 864000000; // 1 day in ms
	static final String PREFIX ="Bearer";
	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String getToken(String username) {
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
				.signWith(key)
				.compact();
		return token;
	}

}
