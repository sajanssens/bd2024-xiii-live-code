package com.infosupport.h7;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {
    private String name;
    private int age;

    private Gender gender;
    private Laptop dbo;
    private Laptop dwb;

    private List<Shoe> shoes = new ArrayList<>();
    // private Shoe[] shoesToo = new Shoe[10];

    public void setAge(int age) {
        if (age < 130) {
            this.age = age;
            System.out.println("Age is veranderd");
        }
    }

    public void add(Shoe newShoe) {
        this.shoes.add(newShoe);
    }
}
