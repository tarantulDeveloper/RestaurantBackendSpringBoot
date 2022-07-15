package com.database.controllers;

import com.database.model.Talas;
import com.database.repo.TalasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TalasController {
    @Autowired
    private TalasRepo talasRepo;

    @PostMapping("/talas")
    public void addLocation(@RequestBody String location){
        Talas talas = new Talas();
        talas.setLocation(location);
        talasRepo.save(talas);
    }

    @GetMapping("/talas")
    public List<Talas> getTalas(){
        return (List<Talas>) talasRepo.findAll();
    }
}
