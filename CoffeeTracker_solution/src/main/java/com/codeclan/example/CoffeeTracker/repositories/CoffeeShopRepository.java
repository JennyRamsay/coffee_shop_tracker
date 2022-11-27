package com.codeclan.example.CoffeeTracker.repositories;

import com.codeclan.example.CoffeeTracker.models.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeShopRepository extends JpaRepository<CoffeeShop, Long> {

    //TODO: Get all the coffeeShops for a particular region
    // Want: List<CoffeeShop>
    // Have: region string - "Jamaica"
    List<CoffeeShop> findByRegion(String region);


    //TODO: Get distilleries that have whiskies that are 12 years old
    // Want: List<Distillery>
    // Have: age (of whisky)
    List<CoffeeShop> findByCoffeesAge(int age);

}
