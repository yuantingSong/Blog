package com.yuanting.Blog.jwt;

import java.nio.file.attribute.UserPrincipal;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import javax.annotation.PostConstruct;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenProvider {

	@Value("${val.jwt.secretKey}")
	private String secretKey;
	
	@Value("${val.jwt.expirationInMs}")
	private long expirationInMs;
	 
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	public String generateToken(MyUserDetails myUserDetails) {  
		Integer id = myUserDetails;
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + expirationInMs);
		return Jwts.builder()
				.setSubject(Integer.toString(id))              
				.setIssuedAt(now)
				.setExpiration(expiryDate)
	            .signWith(SignatureAlgorithm.HS512, secretKey)
	            .compact();
	}
	
}
