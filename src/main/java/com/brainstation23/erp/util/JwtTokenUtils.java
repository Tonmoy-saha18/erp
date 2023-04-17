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

    public String generateJwtToken(User user) {
        Date startDate = new Date();
        Date expirationDate = new Date(startDate.getTime() + 172_800_000);

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(startDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public UUID getUserIdFromJwtToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return UUID.fromString(claims.getSubject());
    }
}
