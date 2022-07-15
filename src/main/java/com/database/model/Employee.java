package com.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity(name = "employee")
public class Employee {
    @Id
    private String userName;
    private String userPassword;
    private String department;
    private int salary;
    private String role;

    private String jobBegin;
    private String jobEnd;
    private String branch;
    private int experience;


    private String activationCode;

    private int enable;

    private String firstName;
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<WorkToDo> workToDos;

    // MY CONSTRUCTORS
    public Employee() {
    }

    public Employee(String userName, String userPassword, String department,
                    int salary, String role, String jobBegin, String jobEnd,
                    String branch, int experience,  String activationCode,
                    int enable, String firstName, String lastName) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.department = department;
        this.salary = salary;
        this.role = role;
        this.jobBegin = jobBegin;
        this.jobEnd = jobEnd;
        this.branch = branch;
        this.experience = experience;
        this.activationCode = activationCode;
        this.enable = enable;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }



    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Set<WorkToDo> getWorkToDos() {
        return workToDos;
    }

    public String getJobBegin() {
        return jobBegin;
    }

    public String getJobEnd() {
        return jobEnd;
    }

    public String getBranch() {
        return branch;
    }

    public int getExperience() {
        return experience;
    }

    public void setJobBegin(String jobBegin) {
        this.jobBegin = jobBegin;
    }

    public void setJobEnd(String jobEnd) {
        this.jobEnd = jobEnd;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    //MY GETTERS
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    //MY SETTERS

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setWorkToDos(Set<WorkToDo> workToDos) {
        this.workToDos = workToDos;
    }

}
