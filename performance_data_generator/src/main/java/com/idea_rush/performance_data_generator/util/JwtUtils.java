package com.idea_rush.performance_data_generator.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;

@Slf4j
@Component
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String secretKey;
    private Key SIGNING_KEY;
    private final Integer ACCESS_TOKEN_DURATION_SECONDS = 60 * 60 * 24 * 30 * 2;

    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        SIGNING_KEY = Keys.hmacShaKeyFor(bytes);
    }

    public String generateToken(Long userId) {
        Instant now = Instant.now();
        Instant expiryDateOfAccessToken = now.plusSeconds(ACCESS_TOKEN_DURATION_SECONDS);

        return Jwts.builder()
                .setClaims(Map.of(
                        "userId", userId,
                        "iat", now.getEpochSecond(),
                        "exp", expiryDateOfAccessToken.getEpochSecond()
                ))
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

}