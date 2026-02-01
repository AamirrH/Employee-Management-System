package com.codeexample.springbootrestapi.services;


import com.codeexample.springbootrestapi.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.secretkey}")
    // Injects Value from application.properties, thus improving code security
    private String secretKey;

    // creates a hmacSha key using secretKey by converting it into bytes first
    private SecretKey getsecretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }


    // generates a token, by getting the header, payload { username,id,roles} etc
    public String generateToken(UserEntity userEntity){
        return Jwts.builder()
                .subject(userEntity.getId().toString())
                .claim("username",userEntity.getUsername())
                .claim("roles",userEntity.getRoles())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*120))
                .signWith(getsecretKey())
                .compact();
    }
    public Long getUserIdFromToken(String token){
        Claims claim = Jwts.parser()
                .verifyWith(getsecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return Long.valueOf(claim.getSubject());

    }


}
