package com.infosupport.h10.stringmutator.fout;

public class LaatsteRegel {

    public String perform(String s) {
        return s.lines().reduce((total, line) -> line).orElseThrow();
        // String[] split = s.split(System.lineSeparator());
        // return split[split.length - 1];
    }
}
