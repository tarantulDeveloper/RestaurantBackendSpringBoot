package com.database.controllers;

import com.database.model.Batken;
import com.database.repo.BatkenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BatkenController {
    @Autowired
    private BatkenRepo batkenRepo;

    @PostMapping("/batken")
    public void addLocation(@RequestBody String location){
        Batken batken = new Batken();
        batken.setLocation(location);
        batkenRepo.save(batken);
    }

    @GetMapping("/batken")
    public List<Batken> getBat(){
        return (List<Batken>) batkenRepo.findAll();
    }
}
