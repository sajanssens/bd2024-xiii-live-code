package com.infosupport.h7;

import lombok.Data;

@Data
public class Laptop {
    private String brand;
    private double /* BigDecimal!! */ price;

    public Laptop() {

    }

    public Laptop(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Laptop(String brand) {
        this.brand = brand;
    }

    public Laptop(double price) {
        this.price = price;
    }

    public Laptop(long price) {
        this.price = price;
    }
}
