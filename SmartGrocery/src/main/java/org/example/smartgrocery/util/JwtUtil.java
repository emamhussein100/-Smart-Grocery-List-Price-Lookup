package org.example.smartgrocery.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "mySecretKeymySecretKeymySecretKey1234567890";

//    private static final String BASE64_SECRET = Base64.getEncoder().encodeToString(
//            "mySuperSecretKeyForJWTThatIsAtLeast256BitsLong1234567890".getBytes()
//    );

    private Key getKey() {
        byte[] keyBytes = SECRET.getBytes();
        if (keyBytes.length < 32) {
            throw new IllegalArgumentException("Secret key must be at least 32 bytes");
        }
        return Keys.hmacShaKeyFor(keyBytes);

    }

    public String generateToken(String username, String role, Long userId) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("userId",userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}