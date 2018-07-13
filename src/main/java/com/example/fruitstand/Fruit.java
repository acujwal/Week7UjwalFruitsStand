package com.example.fruitstand;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String image;

    @OneToMany (mappedBy = "fruit",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public Set<Weekday> weekdays;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Weekday> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Set<Weekday> weekdays) {
        this.weekdays = weekdays;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
