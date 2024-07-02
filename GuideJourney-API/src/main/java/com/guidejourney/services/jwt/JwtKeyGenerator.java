package com.guidejourney.services.jwt;

import java.util.Base64;

import io.jsonwebtoken.security.Keys;

public class JwtKeyGenerator {
    public static void main(String[] args) {
        byte[] keyBytes = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded();
        String secretKey = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Generated JWT Secret Key: " + secretKey);
    }
}
