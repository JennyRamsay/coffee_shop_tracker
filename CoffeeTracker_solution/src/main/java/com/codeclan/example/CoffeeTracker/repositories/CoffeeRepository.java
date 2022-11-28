package com.codeclan.example.CoffeeTracker.repositories;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {


    //TODO: Get all the coffees for a particular strength
    // What do I want back: List<Coffee>
    // What do I have - strength 8
    List<Coffee> findByStrength(int strength);


    //TODO: Get all the coffee from a particular CoffeeShop that's a specific age
    // find all the coffee from Costa Rica that's 1 month old
    // Want: List<Coffee>
    // Have: CoffeeShop name: ("Revival") AND a coffee age (15)
    List<Coffee> findByCoffeeShopNameAndAge(String coffeeShopName, int age);
    List<Coffee> findByCoffeeShopIdAndAge(Long distId, int age); // Bonus, just to show it can be done.


    //TODO: Get all the coffee from a particular region
    // Want: List<Coffee>
    // Have : Region
    List<Coffee> findByCoffeeShopRegion(String region);
}


