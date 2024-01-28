package com.example.demo.Sersvisers.impl;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service

public class JWTservicesimpl {

    private String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 24))
                .signWith(getSignkey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public String extractUserName(String token) {

        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimsResolvers){
        final Claims claims =extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignkey()).build().parseClaimsJws(token).getBody();
    }


    private Key getSignkey() {
        byte[] Key = Decoders.BASE64.decode("796b21a1a13c79ad8dd373661f8f9562d312f7dab881fbeebba4db63c2417a3a");
        return Keys.hmacShaKeyFor(Key);
    }










}
