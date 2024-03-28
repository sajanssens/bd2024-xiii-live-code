package com.infosupport.h10.stringmutator.fout;

public class Derde {

    public String doe(String s) {
        return s.lines().reduce((total, line) -> line).orElseThrow();
        // String[] split = s.split(System.lineSeparator());
        // return split[split.length - 1];
    }
}
