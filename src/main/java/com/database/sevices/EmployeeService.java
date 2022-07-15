package com.database.sevices;

import com.database.model.Employee;
import com.database.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSender mailSender;

//    public Employee registerNewEmployee(Employee employee) throws ResourceNotFoundException {
//        Optional<Employee> employee1 = employeeRepo.findById(employee.getUserName());
//        if(employee1 != null){
//            return new ResourceNotFoundException("User is already exist");
//        }
//
//        employee.setRole("USER");
//        employee.setUserPassword(getEncodedPassword(employee.getUserPassword()));
//        return employeeRepo.save(employee);
//    }

    public boolean registerNewEmployee(Employee employee) {
        Optional<Employee> employee1 = employeeRepo.findById(employee.getUserName());
        if(employee1.isPresent()){
            return false;
        }
        employee.setActivationCode(UUID.randomUUID().toString());
        employee.setRole("USER");
        employee.setUserPassword(getEncodedPassword(employee.getUserPassword()));
        employee.setEnable(0);



        String message = String.format(
                "Hello, %s! \n" +
                        "Welcome to our system. Visit the link to activate your account: http://localhost:8080/activate/%s",
                employee.getFirstName(),
                employee.getActivationCode()
        );
        mailSender.send(employee.getUserName(),"Activation code",message);

        employeeRepo.save(employee);
        return true;
    }



    public Employee changeRole(String userName, String roleName){
        Employee employee = employeeRepo.findById(userName).get();
        employee.setRole(roleName);
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(String userName) {
        employeeRepo.deleteById(userName);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
