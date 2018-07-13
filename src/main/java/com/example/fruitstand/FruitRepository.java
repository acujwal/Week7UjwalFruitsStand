package com.example.fruitstand;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FruitRepository extends CrudRepository<Fruit, Long>{
    List<Fruit> findByNameIgnoreCase(String search);

}
