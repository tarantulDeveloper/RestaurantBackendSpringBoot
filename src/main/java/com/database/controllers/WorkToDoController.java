package com.database.controllers;

import com.database.ResourceNotFoundException;
import com.database.model.Employee;
import com.database.model.WorkToDo;
import com.database.repo.EmployeeRepo;
import com.database.repo.WorkToDoRepo;
import com.database.sevices.WorkToDoService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkToDoController {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    private WorkToDoService workToDoService;

    @Autowired
    private WorkToDoRepo workToDoRepo;

    @PostMapping({"/createNewWork"})
    public WorkToDo createNewRole(@RequestBody WorkToDo workToDo) {
        return workToDoService.createNewWork(workToDo);
    }

    @PostMapping("/location")
    public void addLocationToLocation(@RequestBody String locationName) {
        workToDoRepo.insertInto(locationName);
    }



}
