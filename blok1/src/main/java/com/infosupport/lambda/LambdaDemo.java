package com.infosupport.lambda;

import com.infosupport.h7.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

import static com.infosupport.streams.StreamDemo.people;

public class LambdaDemo {

    public static void main(String[] args) {
        IntFunction<Integer> f = x -> x * x;
        Consumer<Integer> c = (Integer i) -> System.out.println(i);

        double result = f.apply(2);
        long round = Math.round(1.2);

        people.stream()
                .map(p -> p.getAge())
                .forEach(a -> System.out.println(a));

        List<Person> resultToo =
                selecteer(people,
                        p -> {
                            System.out.println(p);
                            System.out.println("Hello");
                            return p.getAge() >= 18;
                        }
                );

        selecteer(people, p -> p.getName().startsWith("A"));
        selecteer(people, p -> p.getName().startsWith("A") && p.getAge() >= 18 && p.getAge() <= 65);

        // ... as anonymous inner class
        Predicate<Person> pensioenGerechtigd = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() <= 67;
            }
        };

        // ... as non-anonymous class
        PensioenGerechtigd pensioenGerechtigdNotAnonymous = new PensioenGerechtigd();

        // all the same...
        selecteer(people, pensioenGerechtigd);
        selecteer(people, pensioenGerechtigdNotAnonymous);
    }

    public List<Person> selecteerOpLeeftijd(List<Person> people) {
        List<Person> selectie = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() >= 18) {
                selectie.add(person);
            }
        }
        return selectie;
    }

    public List<Person> selecteerOpNaam(List<Person> people) {
        List<Person> selectie = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().startsWith("A")) {
                selectie.add(person);
            }
        }
        return selectie;
    }

    public static List<Person> selecteer(List<Person> people, Predicate<Person> conditie) {
        List<Person> selectie = new ArrayList<>();
        for (Person person : people) {
            if (conditie.test(person)) {
                selectie.add(person);
            }
        }
        return selectie;
    }
}

class PensioenGerechtigd implements Predicate<Person> {
    @Override
    public boolean test(Person person) {
        return person.getAge() <= 67;
    }
}
