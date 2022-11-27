package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

    /*

     */

    /**
     * Handles routes and filters:
     *     GET /coffees
     *     GET /coffees?year=1995
     *     GET /coffees?coffeeShopName=Revival&age=15
     *     GET /coffees?coffeeShopRegion=Jamaica
     * @return `ResponseEntity<List<Coffee>>`
     */
    @GetMapping(value = "/coffees")
    public ResponseEntity getAllCoffeesAndFilters(
            @RequestParam(required = false, name = "year") Integer year,
            @RequestParam(required = false, name = "coffeeShopName") String shopName,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "coffeeShopRegion") String shopRegion
    ){

        // if we have the year string then do the year query
        if (year != null){
            return new ResponseEntity(coffeeRepository.findByYear(year), HttpStatus.OK);
        }
        // if we have the coffeeShopName string AND age  do the coffeeShopName AND age query
        if (shopName != null && age != null){
            List<Coffee> foundCoffee = coffeeRepository.findByCoffeeShopNameAndAge(shopName, age);
            return new ResponseEntity(foundCoffee, HttpStatus.OK);
        }
        // if we have the coffeeShopRegion string do the region query
        if (shopRegion != null){
            return new ResponseEntity(coffeeRepository.findByCoffeeShopRegion(shopRegion), HttpStatus.OK);
        }

        // default: we have none of the query strings GET /coffees
        return new ResponseEntity(coffeeRepository.findAll(), HttpStatus.OK);
    }

}

