package com.codeexample.springbootrestapi.controllers;

import com.codeexample.springbootrestapi.dto.SignUpDTO;
import com.codeexample.springbootrestapi.dto.UserDTO;
import com.codeexample.springbootrestapi.entities.UserEntity;
import com.codeexample.springbootrestapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody SignUpDTO signUpDTO) {
        return ResponseEntity.ok(userService.signup(signUpDTO));

    }


}
