package com.infosupport.cdi.welddemo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class Ballenfabriek {

    @Produces
    public List<Integer> lijstje() {
        return Arrays.asList(1, 2, 3, 4);
    }
}
