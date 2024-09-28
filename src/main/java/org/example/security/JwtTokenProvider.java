package org.example.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtTokenProvider {

    public static final SecretKey SECRET = new SecretKeySpec(new byte[64], "HmacSHA256");
    public static final long EXPIRATION_TIME = 86400000; // 1 day

    public String generateToken(String email, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .subject(email)
                .claim("authorities", role)
                .issuedAt(new Date())
                .expiration(expiryDate)
                .signWith(SECRET)
                .compact();
    }
}
