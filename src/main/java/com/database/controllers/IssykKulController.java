package com.database.controllers;

import com.database.model.IssykKul;
import com.database.repo.IssykKulRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssykKulController {
    @Autowired
    private IssykKulRepo issykKulRepo;

    @PostMapping("/issykkul")
    public void addLocation(@RequestBody String location) {
        IssykKul issykKul = new IssykKul();
        issykKul.setLocation(location);
        issykKulRepo.save(issykKul);
    }

    @GetMapping("/issykkul")
    public List<IssykKul> getAll(){
        return (List<IssykKul>) issykKulRepo.findAll();
    }

}
