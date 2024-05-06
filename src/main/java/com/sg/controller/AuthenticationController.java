package com.sg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/*
 * AuthenticationController is a Rest Controller that contain API endpoints of authentication
 *
 * @author Sudhanshu Gupta
 */

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    /*
     * registerUser() : Account of a user is created with this method
     */

    @PostMapping("/user-register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request){
        logger.info("authenticationController: registerUser() method invoke");
        return ResponseEntity.ok(authenticationService.registerUser(request));
    }
    /*
     * registerAdmin() : Account of a admin is created with this method
     */
    @PostMapping("/admin-register")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request){
        logger.info("authenticationController: registerAdmin() method invoke");
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }
    /*
     * authenticate() : It is used for the authentication purpose, weather the user is registered or not
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        logger.info("authenticationController: authenticate() method invoke");
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}