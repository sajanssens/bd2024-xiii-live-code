package com.infosupport.utjava.tdd;

public class Factorial {

    private Factorial() { }

    public static long fac(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n moet groter dan nul zijn");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
}
