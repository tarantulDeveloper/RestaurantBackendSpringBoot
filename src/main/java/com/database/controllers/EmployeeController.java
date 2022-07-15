package com.database.controllers;

import com.database.ResourceNotFoundException;
import com.database.model.Employee;
import com.database.model.WorkToDo;
import com.database.repo.EmployeeRepo;
import com.database.repo.WorkToDoRepo;
import com.database.sevices.EmployeeService;
import com.database.sevices.WorkToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    WorkToDoService workToDoService;

    @Autowired
    WorkToDoRepo workToDoRepo;



    //POSTS
    @PostMapping({"/register"})
    public boolean registerNewEmployee(@RequestBody Employee employee) {
        return employeeService.registerNewEmployee(employee);
    }

    @PostMapping({"/work/add/{userName}"})
    public WorkToDo assignWorkToEmployee (@RequestBody String workName, @PathVariable String userName)
            throws ResourceNotFoundException {
        System.out.println("Started");
        Employee employee = employeeRepo.findById(userName).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
        System.out.println(employee.getUserName());

        WorkToDo workToDo = new WorkToDo(workName,employee);
        return workToDoRepo.save(workToDo);

    }


    //DELETES
    @DeleteMapping({"/delete/{userName}"})
    public ResponseEntity<?> deleteEmployeeById(@PathVariable(value = "userName") String userName) {
        workToDoService.deleteAllWork(userName);
        employeeService.deleteEmployee(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/work/{id}")
    public ResponseEntity<?> deleteWork(@PathVariable(value = "id") Integer id){
        System.out.println(id+ " id ");
        workToDoRepo.deleteWork(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





    //GETS
    @GetMapping({"/users"})
    public List<Employee> getAllUsers(){
        return (List<Employee>) employeeRepo.findAll();
    }

    @GetMapping({"/users/{userName}"})
    public Employee getEmployeeByUserName (@PathVariable(value = "userName") String userName)
        throws ResourceNotFoundException {
        return employeeRepo.findById(userName).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found")
        );
    }

    @GetMapping("activate/{activation}")
    public String activateEmployee(@PathVariable(value = "activation") String code){
        Employee employee = employeeRepo.findByActivationCode(code);
        employee.setEnable(1);
        employeeRepo.save(employee);
        return "<h1 style='text-align: center; font-size: 40px; margin-top: 100px; color: green;'>User was activated</h1>";
    }

    @GetMapping("works/get/{userName}")
    public List<WorkToDo> getAllOfWorker(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException{
        List<WorkToDo> workToDo = workToDoRepo.findAllByWorker(userName);
        if(workToDo.isEmpty()){
            throw new ResourceNotFoundException("No tasks");
        }
        return workToDo;

    }



    //PUTS
    @PutMapping("users/{userName}")
    public Employee updateEmployee(@PathVariable(value = "userName") String userName,
                                   @RequestBody Employee employeeDetails)
        throws ResourceNotFoundException {
        Employee employee = employeeRepo.findById(userName).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
        employee.setUserName(employeeDetails.getUserName());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        employee.setRole(employeeDetails.getRole());
        employee.setJobBegin(employeeDetails.getJobBegin());
        employee.setJobEnd(employeeDetails.getJobEnd());
        employee.setBranch(employeeDetails.getBranch());
        employee.setExperience(employeeDetails.getExperience());
        employee.setLastName(employeeDetails.getLastName());
        return employeeRepo.save(employee);

    }



//    @PostMapping("/work/{userName}")
//    public WorkToDo setWork(@PathVariable(value = "userName") String userName,@RequestParam(name="work") String work) {
//        WorkToDo workToDo = new WorkToDo(userName, work);
//        return workToDoRepo.save(workToDo);
//    }

}

