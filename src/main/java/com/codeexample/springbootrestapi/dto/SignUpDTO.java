package com.codeexample.springbootrestapi.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class SignUpDTO {

    private String username;
    @Email
    private String email;
    private String password;

}
