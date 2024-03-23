package edu.poly.boatbooking.controller;

import edu.poly.boatbooking.auth.AuthenticationRequest;
import edu.poly.boatbooking.auth.AuthenticationResponse;
import edu.poly.boatbooking.auth.RegisterRequest;
import edu.poly.boatbooking.dto.JwtAuthenticationResponse;
import edu.poly.boatbooking.dto.RefreshTokenRequest;
import edu.poly.boatbooking.dto.SignInRequest;
import edu.poly.boatbooking.dto.SignUpRequest;
import edu.poly.boatbooking.entity.User;
import edu.poly.boatbooking.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> HBLab (@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
