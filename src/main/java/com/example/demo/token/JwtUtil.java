package com.example.demo.token;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    // Secret key used for signing (in-memory key)
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Generate JWT Token using email as subject
    public String generateToken(String email) {

        long expirationMillis = 24 * 60 * 60 * 1000; // 1 day

        return Jwts.builder()
                .setSubject(email)                          // who the token is about
                .setIssuedAt(new Date())                    // issued time
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis)) // expiry
                .signWith(secretKey)                        // sign with key
                .compact();
    }
}



//spring.application.name=AuthicationApi
//
//
//
//spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
//spring.datasource.username=postgres
//spring.datasource.password=Balaji@1337
//spring.datasource.driver-class-name=org.postgresql.Driver
//
//spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
//
//spring.jpa.hibernate.ddl-auto=update
//spring.jpa.show-sql=true
