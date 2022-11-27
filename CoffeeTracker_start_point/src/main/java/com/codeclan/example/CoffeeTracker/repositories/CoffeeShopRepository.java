package com.codeclan.example.CoffeeTracker.repositories;

import com.codeclan.example.CoffeeTracker.models.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeShopRepository extends JpaRepository<CoffeeShop, Long> {
}
