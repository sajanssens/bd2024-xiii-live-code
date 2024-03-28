package com.infosupport.h10.stringmutator.goed;

public class LaatsteRegel implements StringMutator {

    @Override
    public String mutate(String s) {
        return s.lines().reduce((total, line) -> line).orElseThrow();
    }
}
