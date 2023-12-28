package com.ironhack.CarbonFootprintCalculator.Services.Implementation;

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
public class JWTServiceImpl {

    private String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
                .signWith(getSiginKey(), SignatureAlgorithm.ES256)
                .compact();
    }

    private Key getSiginKey(){
        byte[] key = Decoders.BASE64.decode("5Tz7WplYvL57ZK868IFG1twpQKr9H3yIeDuD3RBjzL4=");
        return Keys.hmacShaKeyFor(key);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extractAllClaim(token);
        return claimsResolvers.apply(claims);
    }
    private Claims extractAllClaim(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSiginKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    private boolean isTokenExpired(String token){
        Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration != null && expiration.before(new Date());

    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUserId(String token){
        return extractClaim(token, claims -> claims.get("id", String.class));
    }
    }


