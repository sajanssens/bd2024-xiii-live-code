package com.infosupport.h13.boxes;

import com.infosupport.h7.Person;

import java.util.List;

public class Util {

    public static void addPersonTo(List<Person> personList, Person p) {
        personList.add(p);
    }

    public static <T> List<T> addTo(List<T> list, T t) {
        System.out.println("T is T");
        list.add(t);
        T t1 = list.get(0);
        return list;
    }

    // This one can be overloaded.
    // The second (String) parameter makes it unique from the method above:
    public static List<String> addTo(List<String> list, String t) {
        System.out.println("T is string");
        return list;
    }

    // This one can not be overloaded, due to type erasure.
    // public static <T> List<T> addTo(List<T> list) {
    //
    // }
    //
    // public static List<String> addTo(List<String> list) {
    //
    // }
}
