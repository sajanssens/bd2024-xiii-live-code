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

        double square = f.apply(2);
        long round = Math.round(1.2);

        people.stream()
                .map(p -> p.getAge())
                .forEach(a -> System.out.println(a));

        List<Person> result;

        result =
                selecteer(people,
                        p -> { // a lambda can contain multiple statements:
                            System.out.println(p);
                            System.out.println("Hello");
                            return p.getAge() >= 18;
                        }
                );

        result = selecteer(people, p -> p.getName().startsWith("A"));
        result = selecteer(people, p -> p.getName().startsWith("A") && p.getAge() >= 18 && p.getAge() <= 65);

        // Variable behaviour:

        // As lambda:
        Predicate<Person> pensioenGerechtigd = person -> person.getAge() <= 67;

        // ... as anonymous inner class
        Predicate<Person> pensioenGerechtigdAnonymous = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() <= 67;
            }
        };

        // ... as non-anonymous class
        PensioenGerechtigd pensioenGerechtigdNotAnonymous = new PensioenGerechtigd();

        // It's all the same...!
        result = selecteer(people, pensioenGerechtigd);
        result = selecteer(people, pensioenGerechtigdAnonymous);
        result = selecteer(people, pensioenGerechtigdNotAnonymous);
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
