package com.codeexample.springbootrestapi.controllers;


import com.codeexample.springbootrestapi.dto.EmployeeDTO;
import com.codeexample.springbootrestapi.entities.EmployeeEntity;
import com.codeexample.springbootrestapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Provides a JSON response, Jackson Library converts to JSON
public class EmployeeController {


    // Not a good practice to inject Repository Bean inside Controller Layer, this should be done in Service Layer.

    private final EmployeeRepository employeeRepository;

    //Bean Injection
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // GetMapping - used to get data/resource from the server.
    @GetMapping(path="/employees/{employeeID}")
    // Value inside employeeID gets injected inside ID.
    public EmployeeEntity getEmployee(@PathVariable(name = "employeeID") int ID){
        return employeeRepository.findById(ID).orElse(null);
    }

    //Request Params are optional and we may or may not provide them in the URL.
    @GetMapping(path = "/employees")
    public List<EmployeeEntity> getEmployeeAge(@RequestParam(required = false) int age,
                                 @RequestParam(required = false) String name){
        return employeeRepository.findAll() ;

    }

    //Browser can only send GET Requests, so we need Postman for these mappings.
    @PostMapping(path = "/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployee){
        //using Bean of EmployeeRepository to call "Already Implemented Methods" by passing appropriate parameters
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployeebyId(){
        return "Hello From POST";
    }





}
