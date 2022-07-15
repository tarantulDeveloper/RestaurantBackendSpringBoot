package com.database.controllers;

import com.database.model.Chuy;
import com.database.repo.ChuyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChuyController {
    @Autowired
    private ChuyRepo chuyRepo;

    @PostMapping("/chuy")
    public void addLocation(@RequestBody String location){
        Chuy chuy = new Chuy();
        chuy.setLocation(location);
        chuyRepo.save(chuy);
    }

    @GetMapping("/chuy")
    public List<Chuy> getCh(){
        return (List<Chuy>) chuyRepo.findAll();
    }
}
