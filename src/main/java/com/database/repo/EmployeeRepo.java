package com.database.repo;

import com.database.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String> {
    Employee findByActivationCode(String code);
}
