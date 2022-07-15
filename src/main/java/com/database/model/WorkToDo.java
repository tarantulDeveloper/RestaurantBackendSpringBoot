package com.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name="work_to_do")
public class WorkToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String work;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id",referencedColumnName = "userName")
    private Employee employee;

    //MY CONSTRUCTORS
    public WorkToDo() {
    }

    public WorkToDo(String work, Employee employee) {
        this.work = work;
        this.employee = employee;
    }

    //MY GETTERS
    public String getWork() {
        return work;
    }

    public Employee getEmployee() {
        return employee;
    }

    //MY SETTERS
    public void setWork(String work) {
        this.work = work;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
