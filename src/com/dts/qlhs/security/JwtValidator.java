package com.dts.qlhs.security;

import com.dts.qlhs.domain.entities.Account;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtValidator {
	public Account validate(String token) {
		Account jwtUser = null;
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey("SECRET").parseClaimsJws(token).getBody();
			jwtUser = Account.getInstence();
			jwtUser.setAccName(claims.getSubject());
			jwtUser.setAccPass(claims.get("password").toString());
//			jwtUser.setRole(Integer.parseInt(claims.get("roles").toString()));
		} catch (Exception e) {
			System.out.println(e);
		}
		return jwtUser;
	}

}
