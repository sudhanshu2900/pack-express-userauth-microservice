package com.sg.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sg.configuration.JwtService;
import com.sg.entity.Role;
import com.sg.entity.User;
import com.sg.entity.UserRepository;

import lombok.RequiredArgsConstructor;

/*
 * AuthenticationService is a class that hold all the business logic of Authentication
 */

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    /*
     * registerUser(): Provide all the information of User and save into database
     */

    public AuthenticationResponse registerUser(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().role(Role.USER).token(jwtToken).build();
    }
    /*
     * registerAdmin(): Provide all the information of Admin and save into database
     */
    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var admin = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        userRepository.save(admin);
        var jwtToken = jwtService.generateToken(admin);
        return AuthenticationResponse.builder().role(Role.ADMIN).firstname(admin.getFirstname()).token(jwtToken).build();
    }

    /*
     * authenticate(): On passing Email and Password entity will be authenticate and provide proper response
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().id(user.getId()).firstname(user.getFirstname()).role(user.getRole()).token(jwtToken).build();
    }

}