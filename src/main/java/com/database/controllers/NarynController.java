package com.database.controllers;

import com.database.model.Naryn;
import com.database.repo.NarynRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NarynController {
    @Autowired
    private NarynRepo narynRepo;

    @PostMapping("/naryn")
    public void addLocation(@RequestBody String location) {
        Naryn naryn = new Naryn();
        naryn.setLocation(location);
        narynRepo.save(naryn);
    }

    @GetMapping("/naryn")
    public List<Naryn> getNaryn(){
        return (List<Naryn>) narynRepo.findAll();
    }
}
