package com.infosupport.h7;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data @RequiredArgsConstructor
public class Person extends Human {
    private String name;
    private int age;

    private Gender gender;
    private Laptop dbo;
    private Laptop dwb;

    private ShoeManager shoeManager = new ShoeManager();
    private int footSize;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // private Shoe[] shoesToo = new Shoe[10];

    public void setAge(int age) {
        if (age < 130) {
            // this.age = age;
            System.out.println("Age is veranderd");
        }
    }

    private void setShoeManager(ShoeManager shoeManager) {
        this.shoeManager = shoeManager;
    }

    public boolean fit(Shoe newShoe) {
        if (this.footSize == newShoe.getSize()) {
            return this.shoeManager.add(newShoe);
        }
        return false;
    }

    public List<Shoe> findDr(String brand) {
        if (brand.startsWith("Dr.")) {
            return this.shoeManager.find(brand);
        }

        return List.of();
    }
}
