package com.dts.qlhs.security;

import java.util.Date;

import com.dts.qlhs.domain.entities.Account;
import com.dts.qlhs.domain.entities.HocSinh;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtGenetator {
	
	 public String generate(Account jwtAcc) {
	        Claims claims = Jwts.claims()
	                .setSubject(jwtAcc.getAccName()); 
	        
	        claims.put("password", jwtAcc.getAccPass());
//	        claims.put("roles", jwtAcc.getRole());
	        Date date = new Date(); 
	        return Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, "SECRET")
	                .setIssuedAt(date)
	                .setExpiration(new Date(date.getTime() + System.currentTimeMillis()))
	                .compact(); 
	    }
	  
//	  public JwtUser validate(String token) {
//		  JwtUser jwtUser = null;
//		  Claims claims =null;
//	        try {
//	             claims = Jwts.parser() 
//	                    .setSigningKey("SECRET")
//	                    .parseClaimsJws(token)
//	                    .getBody();
//	            jwtUser = new JwtUser();
//	            jwtUser.setAccName(claims.getSubject());
//	            jwtUser.setAccPass(claims.get("password").toString());
//	            jwtUser.setAccRole(Integer.parseInt(claims.get("roles").toString()));
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
//	        System.out.println(claims);
//	        return jwtUser;
//	    }

}	
