package com.database.controllers;

import com.database.model.Osh;
import com.database.repo.OshRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OshController {
    @Autowired
    private OshRepo oshRepo;

    @PostMapping("/osh")
    public void addLocation(@RequestBody String location) {
        Osh osh = new Osh();
        osh.setLocation(location);
        oshRepo.save(osh);
    }

    @GetMapping("/osh")
    public List<Osh> getOsh() {
        return (List<Osh>) oshRepo.findAll();
    }
}
