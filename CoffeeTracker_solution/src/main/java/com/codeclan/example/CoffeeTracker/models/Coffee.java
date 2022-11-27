package com.codeclan.example.CoffeeTracker.models;

import javax.persistence.*;

@Entity
@Table(name = "coffees")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "coffeeShop_id", nullable = false)
    private CoffeeShop coffeeShop;

    public Coffee(String name, int age,int year, CoffeeShop coffeeShop) {
        this.name = name;
        this.age = age;
        this.year = year;
        this.coffeeShop = coffeeShop;
    }

    public Coffee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
