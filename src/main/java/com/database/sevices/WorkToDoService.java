package com.database.sevices;

import com.database.model.WorkToDo;
import com.database.repo.WorkToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableJpaRepositories(basePackages = "com.database.repo")
public class WorkToDoService {

    @Autowired
    private WorkToDoRepo workToDoRepo;

    public WorkToDo createNewWork(WorkToDo workToDo) {
        return workToDoRepo.save(workToDo);
    }

    public void deleteAllWork(String userName){
        workToDoRepo.deleteALlById(userName);
    }


}
