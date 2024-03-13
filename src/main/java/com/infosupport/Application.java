package com.infosupport;

import com.infosupport.hello.Hello;

import static com.infosupport.hello.Hello.eenAndereFunctie;
import static java.lang.String.format;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // formatting strings:
        String name = "Bram";
        String message = "Hello world $name!".replace("$name", name);
        String message2 = format("Hello world %s!", name);
        System.out.printf("Hello world %s!", name);

        // calling other functions:
        Hello.eenFunctie();
        eenAndereFunctie(); // use static imported function
        com.infosupport.hello2.Hello.hello(); // fully qualified name needed

        int abs = Math.abs(-2);

        // kebab-case-looks-like-this
        // snake_case_is_this
    }

    // This is Javadoc:

    /**
     * Method calculates the faculty
     *
     * @param n the number to calculate
     * @return the faculty of n
     */
    public static long fac(int n) {
        // ...
        // ...
        return 42;
    }
}
