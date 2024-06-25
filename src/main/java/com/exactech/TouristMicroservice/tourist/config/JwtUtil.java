package com.exactech.TouristMicroservice.tourist.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
    private final String secretKey = "2D4A614E645267556B58703273357638792F423F4428472B4B6250655368566D";

    public String generateToken(String email) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 2592000000L; // 30 días en milisegundos
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }
}
