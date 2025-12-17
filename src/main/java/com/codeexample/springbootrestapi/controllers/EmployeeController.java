package com.codeexample.springbootrestapi.controllers;


import com.codeexample.springbootrestapi.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Provides a JSON response, Jackson Library converts to JSON
public class EmployeeController {


    // GetMapping - used to get data/resource from the server.
    @GetMapping(path="/employees/{employeeID}")
    // Value inside employeeID gets injected inside ID.
    public EmployeeDTO getEmployee(@PathVariable(name = "employeeID") int ID){
        return new EmployeeDTO();
    }

    //Request Params are optional and we may or may not provide them in the URL.
    @GetMapping(path = "/employees")
    public String getEmployeeAge(@RequestParam(required = false) int age,
                                 @RequestParam(required = false) String name){
        return "Age of employee is " + age +" "+ name ;

    }

    //Browser can only send GET Requests, so we need Postman for these mappings.
    @PostMapping(path = "/employees")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setEmployeeId(47);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployeebyId(){
        return "Hello From POST";
    }





}
