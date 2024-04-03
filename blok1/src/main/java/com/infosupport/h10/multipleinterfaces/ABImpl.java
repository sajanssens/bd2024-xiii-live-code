package com.infosupport.h10.multipleinterfaces;

public class ABImpl implements A, B {

    @Override
    public void anAbstractMethod() {
        System.out.println("anAbstractMethod override");
    }

    @Override
    public void aDefaultMethod() {
        // Optionally, add:
        // A.super.aDefaultMethod();
        // B.super.aDefaultMethod();
    }
}
