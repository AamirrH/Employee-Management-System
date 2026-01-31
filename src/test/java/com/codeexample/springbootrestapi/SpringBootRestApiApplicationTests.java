package com.codeexample.springbootrestapi;

import com.codeexample.springbootrestapi.entities.UserEntity;
import com.codeexample.springbootrestapi.services.JWTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRestApiApplicationTests {

    @Autowired
    private JWTService jwtService;

    @Test
    void contextLoads() {

        UserEntity user = new UserEntity();
        user.setId(44L);
        user.setUsername("username1");
        user.setPassword("password1");

        String tokenReturned = jwtService.generateToken(user);
        Long idReturned = jwtService.getUserIdFromToken(tokenReturned);
        System.out.println("The token returned is: " + tokenReturned);
        System.out.println("The id from payload returned is: " + idReturned);

    }



}
