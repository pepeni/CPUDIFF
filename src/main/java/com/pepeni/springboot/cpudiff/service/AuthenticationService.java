package com.pepeni.springboot.cpudiff.service;


import com.pepeni.springboot.cpudiff.config.JwtService;
import com.pepeni.springboot.cpudiff.model.Role;
import com.pepeni.springboot.cpudiff.model.User;
import com.pepeni.springboot.cpudiff.repository.UserRepo;
import com.pepeni.springboot.cpudiff.requestResponse.AuthenticationRequest;
import com.pepeni.springboot.cpudiff.requestResponse.AuthenticationResponse;
import com.pepeni.springboot.cpudiff.requestResponse.RegisterRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User
                .builder()
                .email(request.getEmail())
                .nick(request.getNick())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userService.addUser(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userService.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
