package com.cognizant.spring_learn.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import io.jsonwebtoken.security.Keys;
import java.util.Map;
import java.util.*;
import java.util.Base64;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	private static final Logger logger=LoggerFactory.getLogger(AuthenticationController.class);
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader ){
		logger.info("inside authentiate method");
		logger.debug(authHeader);
		
		Map<String,String>map=new HashMap<>() ;
		String user=getUser(authHeader);
		String token=generateJwt(user);
		map.put("token", token);
				
		logger.info("end of authenticate method");
		return map;
	}
	 private String getUser(String authHeader) {
	        logger.debug("Inside getUser()");

	        String encodedCredentials = authHeader.substring("Basic ".length());
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
	        String decodedString = new String(decodedBytes);

	        logger.debug("Decoded credentials: {}", decodedString);

	        String username = decodedString.split(":")[0];
	        logger.debug("Extracted username: {}", username);

	        return username;
	    }


	 private String generateJwt(String user) {
	     logger.debug("Generating JWT for user: {}", user);
	     Key key = Keys.hmacShaKeyFor("my-super-secret-key-which-is-very-long!".getBytes());

	     JwtBuilder builder = Jwts.builder();
	     builder.setSubject(user);
	     builder.setIssuedAt(new Date());
	     builder.setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)); 
	     builder.signWith(key, SignatureAlgorithm.HS256);

	     String token = builder.compact();
	     logger.debug("Generated JWT: {}", token);
	     return token;
	 }

}