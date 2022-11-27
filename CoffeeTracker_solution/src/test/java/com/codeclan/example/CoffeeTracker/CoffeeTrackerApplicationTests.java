package com.codeclan.example.CoffeeTracker;


import com.codeclan.example.CoffeeTracker.models.Coffee;
import com.codeclan.example.CoffeeTracker.models.CoffeeShop;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeTrackerApplicationTests {

	@Autowired
	CoffeeRepository coffeeRepository;

	@Autowired
	CoffeeShopRepository coffeeShopRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindCoffeeByYear(){
		List<Coffee> foundCoffees = coffeeRepository.findByYear(1728);
		assertEquals("Magnum Exotics", foundCoffees.get(0).getName());
	}

	@Test
	public void canFindAllCoffeeShopsForRegion__Jamaica(){
		List<CoffeeShop> foundCoffeeShops = coffeeShopRepository.findByRegion("Jamaica");
		assertEquals("Revival", foundCoffeeShops.get(0).getName());
	}

	@Test
	public void canFindAllCoffeesByCoffeeShopNameAndAge(){
		List<Coffee> foundCoffees = coffeeRepository.findByCoffeeShopNameAndAge("Revival", 15);
		assertEquals("Magnum Exotics", foundCoffees.get(0).getName());
	}


	@Test
	public void canFindAllCoffeesByRegion(){
		List<Coffee> foundCoffees = coffeeRepository.findByCoffeeShopRegion("Jamaica");
		assertEquals("Magnum Exotics", foundCoffees.get(14).getName());
	}

	@Test
	public void canFindShopThatHaveCoffeesWithParticularAge(){
		List<CoffeeShop> foundCoffeeShops = coffeeShopRepository.findByCoffeesAge(6);
		assertEquals("Rise & Shine", foundCoffeeShops.get(0).getName());
	}

}
