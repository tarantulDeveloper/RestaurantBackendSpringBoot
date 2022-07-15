package com.database.controllers;

import com.database.ResourceNotFoundException;
import com.database.model.Employee;
import com.database.model.JwtRequest;
import com.database.model.JwtResponse;
import com.database.repo.EmployeeRepo;
import com.database.sevices.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        Employee employee = employeeRepo.findById(jwtRequest.getUserName()).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
        if(employee.getEnable()==1){
            return jwtService.createJwtToken(jwtRequest);
        }
        throw new ResourceNotFoundException("User is disabled");



    }

}