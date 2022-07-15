package com.database.controllers;

import com.database.model.JalalAbad;
import com.database.repo.JalalAbadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JalalAbadController {
    @Autowired
    private JalalAbadRepo jalalAbadRepo;

    @PostMapping("/jalalabad")
    public void addLocation(@RequestBody String location) {
        JalalAbad jalalAbad = new JalalAbad();
        jalalAbad.setLocation(location);
        jalalAbadRepo.save(jalalAbad);
    }

    @GetMapping("/jalalabad")
    public List<JalalAbad> getJal(){
        return (List<JalalAbad>) jalalAbadRepo.findAll();
    }
}
