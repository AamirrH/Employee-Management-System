package com.codeexample.springbootrestapi.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    @Email
    private String email;
    private String username;

}
