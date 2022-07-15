package com.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "market_expenses")
public class MarketingExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer instagram=0;
    private Integer facebook=0;
    private Integer lalafo=0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstagram() {
        return instagram;
    }

    public void setInstagram(Integer instagram) {
        this.instagram = instagram;
    }

    public Integer getFacebook() {
        return facebook;
    }

    public void setFacebook(Integer facebook) {
        this.facebook = facebook;
    }

    public Integer getLalafo() {
        return lalafo;
    }

    public void setLalafo(Integer lalafo) {
        this.lalafo = lalafo;
    }

    public MarketingExpenses(Integer id, Integer instagram, Integer facebook, Integer lalafo) {
        this.id = id;
        this.instagram = instagram;
        this.facebook = facebook;
        this.lalafo = lalafo;
    }

    public MarketingExpenses() {
    }
}
