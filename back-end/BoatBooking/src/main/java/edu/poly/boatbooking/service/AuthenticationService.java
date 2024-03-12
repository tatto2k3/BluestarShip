package edu.poly.boatbooking.service;

import edu.poly.boatbooking.auth.AuthenticationRequest;
import edu.poly.boatbooking.auth.AuthenticationResponse;
import edu.poly.boatbooking.auth.RegisterRequest;
import edu.poly.boatbooking.dto.JwtAuthenticationResponse;
import edu.poly.boatbooking.dto.RefreshTokenRequest;
import edu.poly.boatbooking.dto.SignInRequest;
import edu.poly.boatbooking.dto.SignUpRequest;
import edu.poly.boatbooking.entity.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
