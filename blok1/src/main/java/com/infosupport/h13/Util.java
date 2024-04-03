package com.infosupport.h13;

import com.infosupport.h7.Human;
import com.infosupport.h7.Person;

import java.util.List;

public class Util {

    public static void verwerkUnsafeRaw(List personenUnsafe) {
        for (Object o : personenUnsafe) {
            Person p = (Person) o;
            System.out.println(p.getName());
        }
    }

    public static void verwerkSafeRaw(List personenUnsafe) {
        for (Object o : personenUnsafe) {
            if (o instanceof Person) {
                Person p = (Person) o;
                System.out.println(p.getName());
            }
        }
    }

    public static void verwerkSafeInvariant(Person p) {
        System.out.println(p);
    }

    //                                      declaration site (param)
    public static void verwerkSafeInvariant(List<Person> list) {
        // Read:
        Person p = list.get(0);
        // for (Person person : list) {
        //     System.out.println(person.getName());
        // }

        // write:
        list.add(new Person());
        list.add(new Trainee());
        list.add(new Trainer());
    }

    public static void verwerkSafeCovariant(List<? extends Person> list) {
        Person p = list.get(0); // PRODUCE

        if (p instanceof Trainee t) {
            String rank = t.rank;
        }

        // list.add(new Trainee());
    }

    public static void verwerkSafeContravariant(List<? super Person> list) {
        // Person p = list.get(0);

        // if (p instanceof Trainee t) {
        //     String rank = t.rank;
        // }

        // Consume:
        list.add(new Trainee());
        // list.add(new Human());
        list.add(new Person());
    }
}
