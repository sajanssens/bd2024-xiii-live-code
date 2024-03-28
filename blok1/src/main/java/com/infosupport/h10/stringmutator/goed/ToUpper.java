package com.infosupport.h10.stringmutator.goed;

public class ToUpper implements StringMutator {

    @Override
    public String mutate(String s) {
        return s.toUpperCase();
    }
}
