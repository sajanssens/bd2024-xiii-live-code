package com.infosupport.h7;

import java.util.List;

public class ShoeManager {
    private List<Shoe> shoes = List.of(
            new Shoe(41, "Dr. Martens"),
            new Shoe(42, "Nike"),
            new Shoe(48, "Chrizz"),
            new Shoe(47, "VANlIESHOUT"),
            new Shoe(42, "XX"),
            new Shoe(42, "YY")
    );

    public boolean add(Shoe newShoe) {
        return this.shoes.add(newShoe);
    }

    public List<Shoe> find(String size) {
        return this.shoes.stream()
                .filter(s -> s.getBrand().equals(size))
                .toList();
    }
}
