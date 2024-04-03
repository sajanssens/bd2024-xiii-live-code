package com.infosupport.h10.multipleinterfaces;

public interface A {
    void anAbstractMethod();

    default void aDefaultMethod() {
        System.out.println("Default behaviour, may be overridden");
    }
}
