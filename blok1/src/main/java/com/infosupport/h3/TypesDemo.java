package com.infosupport.h3;

public class TypesDemo {
    public static void main(String[] args) {
        int x = 0;

        int i = 1;
        String m = "1";
        int message = i + Integer.parseInt(m);
        System.out.println(message);

        double d = 0.1 + 0.2;
        System.out.println(d);

        int p = 2000;
        int q = 2000;

        Integer i1 = 2;
        Integer i2 = 2;

        System.out.println(p == q);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(p == i1);

    }
}
