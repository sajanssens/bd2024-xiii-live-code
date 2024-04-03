package com.infosupport.h8;

import com.infosupport.h7.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        System.out.println("Declared Methods : -----------------");
        for (Method method : personClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        Person p = new Person("Bram", 90);
        System.out.println("Declared Fields : -----------------");
        for (Field f : p.getClass().getDeclaredFields()) {
            System.out.println(f.getName());
        }

        System.out.println("Before hacking:" + p);

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        // p.name = "HACKIEHACKIE"; // not allowed
        name.set(p, "HACKIEHACKIE");// allowed!

        System.out.println("After hacking:" + p);
    }
}
