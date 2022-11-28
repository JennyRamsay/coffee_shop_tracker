package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.repositories.CoffeeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeShopController {

    @Autowired
    CoffeeShopRepository coffeeShopRepository;


    /**
     * Handles routes and filters:
     *  GET  /coffeeshops
     *  GET  /coffeeshops?region=Jamaica
     *  GET  /coffeeshops?coffeeAge=12
     * @return `ResponseEntity<List<CoffeeShop>>`
     */
    @GetMapping(value = "/coffeeshops")
    public ResponseEntity getAllCoffeeShopsAndFilters(
            @RequestParam(required = false, name = "region") String region,
            @RequestParam(required = false, name = "coffeeAge") Integer coffeeAge

    ){
        // GET  /coffeeshops?region=Jamaica
        if (region != null){
            return new ResponseEntity(coffeeShopRepository.findByRegion(region), HttpStatus.OK);
        }
        // GET /coffeeshops?coffeeAge=6
        if (coffeeAge != null){
            return new ResponseEntity(coffeeShopRepository.findByCoffeesAge(coffeeAge), HttpStatus.OK);
        }
        // GET /coffeeshops
        return new ResponseEntity(coffeeShopRepository.findAll(), HttpStatus.OK);

    }
}
