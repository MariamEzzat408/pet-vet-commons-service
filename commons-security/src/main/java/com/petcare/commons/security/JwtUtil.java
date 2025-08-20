package com.petcare.commons.security;

import com.petcare.commons.model.entity.User;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private final String secretKey;
    private final long jwtExpirationMs;
    private final long refreshTokenExpirationMs;

    public JwtUtil() {
        Dotenv dotenv = Dotenv.configure().load();
        this.secretKey = dotenv.get("JWT_SECRET");
        this.jwtExpirationMs = Long.parseLong(dotenv.get("JWT_EXPIRATION_MS"));
        this.refreshTokenExpirationMs = Long.parseLong(dotenv.get("REFRESH_TOKEN_EXPIRATION_MS"));
    }

    // public String generateToken(String email, List<String> roles) {
    //     return Jwts.builder()
    //             .setSubject(email)
    //             .claim("role", roles)
    //             .setIssuedAt(new Date())
    //             .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
    //             .signWith(SignatureAlgorithm.HS256, secretKey)
    //             .compact();
    // }

    public String generateToken(User user) {

        List<String> roles = user.getRoles().stream()
                                 .map(r -> r.getRoleName().name())
                                 .toList();

        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .claim("email", user.getEmail())
                .claim("role",  roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // public String generateRefreshToken(String email) {
    //     return Jwts.builder()
    //             .setSubject(email)
    //             .setIssuedAt(new Date())
    //             .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpirationMs))
    //             .signWith(SignatureAlgorithm.HS256, secretKey)
    //             .compact();
    // }

    public String generateRefreshToken(User user) {
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpirationMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token,String email){

        return extractClaims(token).getSubject().equals(email);
    }

    public String getSecretKey() {
        return secretKey;
    }


}
