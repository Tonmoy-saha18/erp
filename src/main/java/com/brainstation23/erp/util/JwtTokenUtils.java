package com.brainstation23.erp.util;

import com.brainstation23.erp.model.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenUtils {
    @Value("secret_key")
    private String secretKey;
    private static final long JWT_EXPIRATION_TIME = 48 * 60 * 60 * 1000; // 2 days in milliseconds

    public String generateJwtToken(User user) {
        Date startDate = new Date();
        Date expirationDate = new Date(startDate.getTime() + JWT_EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(startDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public UUID getUserIdFromJwtToken(String token) throws Exception{
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return UUID.fromString(claims.getSubject());
    }
}
