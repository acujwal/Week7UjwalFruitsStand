package com.example.fruitstand;

import javax.persistence.*;

@Entity
public class Weekday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String opentime;
    private String closetime;
    private String days;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fruit")
    private Fruit fruit;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getClosetime() {
        return closetime;
    }

    public void setClosetime(String closetime) {
        this.closetime = closetime;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}