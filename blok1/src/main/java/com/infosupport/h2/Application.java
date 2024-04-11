package com.infosupport.h2;

import com.infosupport.h2.hello2.Hello;

import static com.infosupport.h2.hello.Hello.eenAndereFunctie;
import static java.lang.String.format;

public class Application {

    public static void main(String[] args) {
        Opteller.som(1, 2);

        System.out.println("Hello world!");

        // formatting strings:
        String name = "Bram";
        String message = "Hello world $name!".replace("$name", name);
        String message2 = format("Hello world %s!", name);
        System.out.printf("Hello world %s!", name);

        // calling other functions:
        com.infosupport.h2.hello.Hello.eenFunctie();
        eenAndereFunctie(); // use static imported function
        Hello.hello(); // fully qualified name needed

        int abs = Math.abs(-2);

        // kebab-case-looks-like-this
        // snake_case_is_this

        int som = Opteller.som(1, 2);
        System.out.println(som);
    }

    // This is Javadoc:

    /**
     * Method calculates the factorial
     *
     * @param n the number to calculate
     * @return the factorial of n
     */
    public static long fac(int n) {
        // ...
        // ...
        return 42;
    }
}
