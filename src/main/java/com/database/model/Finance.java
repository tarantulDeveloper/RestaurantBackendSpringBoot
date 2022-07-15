package com.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="finance")
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer marketing=0;
    private Integer salary=0;
    private Integer equipment=0;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarketing() {
        return marketing;
    }

    public void setMarketing(Integer marketing) {
        this.marketing = marketing;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getEquipment() {
        return equipment;
    }

    public void setEquipment(Integer equipment) {
        this.equipment = equipment;
    }





    public Finance(Integer id, Integer marketing, Integer salary, Integer equipment) {
        this.id = id;
        this.marketing = marketing;
        this.salary = salary;
        this.equipment = equipment;

    }

    public Finance() {
    }
}
