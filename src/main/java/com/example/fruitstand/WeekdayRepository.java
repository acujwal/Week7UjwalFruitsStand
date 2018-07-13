package com.example.fruitstand;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeekdayRepository extends CrudRepository<Weekday, Long> {

    List<Fruit> findByDaysIgnoreCase(String search);

}
