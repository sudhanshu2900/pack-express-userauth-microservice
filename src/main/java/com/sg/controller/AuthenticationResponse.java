package com.sg.controller;

import com.sg.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * After succesful validation we got Id, Firstname, Role and JWT token as a response
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {

    private int id;
    private String firstname;
    private Role role;
    private String token;

}