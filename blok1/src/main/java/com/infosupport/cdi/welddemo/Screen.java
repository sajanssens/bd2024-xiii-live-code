package com.infosupport.cdi.welddemo;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Screen {

    public void print() {
        System.out.println("Hello!");
    }
}
