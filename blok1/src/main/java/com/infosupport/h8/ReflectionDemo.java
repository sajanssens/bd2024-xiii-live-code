package com.infosupport.h8;

import com.infosupport.h7.Person;

import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) {
        Person p = new Person("", 90);
        Class<Person> personClass = Person.class;
        for (Method method : personClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }
}
