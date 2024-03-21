package com.infosupport.h7;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String name;
    private int age;

    private Gender gender;
    private Laptop dbo;
    private Laptop dwb;

    private ShoeManager shoeManager = new ShoeManager();
    private int footSize;
    // private Shoe[] shoesToo = new Shoe[10];

    public void setAge(int age) {
        if (age < 130) {
            this.age = age;
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

    public List<Shoe> find(String brand) {
        if (brand.startsWith("Dr.")) {
            return this.shoeManager.find(brand);
        }

        return List.of();
    }
}
