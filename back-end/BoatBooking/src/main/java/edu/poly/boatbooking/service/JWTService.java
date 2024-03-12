package edu.poly.boatbooking.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Objects;

public interface JWTService {
    String extractUsername (String token);
    String generateToken(UserDetails userDetails);
    String generateRefreshToken(Map<String, Objects> extractClaims, UserDetails userDetails);
    boolean isValidToken(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
}
