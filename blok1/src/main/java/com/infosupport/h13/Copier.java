package com.infosupport.h13;

import java.util.List;

public class Copier {

    public static <T extends Number> void copy(List<? extends T> from, List<? super T> to) {
        for (T t : from) {
            to.add(t);
        }
    }
}
