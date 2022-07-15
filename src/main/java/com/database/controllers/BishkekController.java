package com.database.controllers;

import com.database.model.Bishkek;
import com.database.repo.BishkekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BishkekController {
    @Autowired
    private BishkekRepo bishkekRepo;

    @PostMapping("/bishkek")
    public void addLocation(@RequestBody String location){
        Bishkek bishkek = new Bishkek();
        bishkek.setLocation(location);
        bishkekRepo.save(bishkek);
    }

    @GetMapping("/bishkek")
    public List<Bishkek> getBi(){
        return (List<Bishkek>) bishkekRepo.findAll();
    }

}
