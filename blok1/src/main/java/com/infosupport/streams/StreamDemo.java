package com.infosupport.streams;

import com.github.javafaker.Faker;
import com.infosupport.h7.Person;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;
import static java.util.stream.DoubleStream.generate;

public class StreamDemo {
    public static Faker fake = Faker.instance();

    public static List<Person> people = new ArrayList<>(
            List.of(
                    new Person("Bram", 44),
                    new Person("Mieke", 44),
                    new Person("Niek", 13),
                    new Person("Gijs", 10)
            )
    );

    public static void main(String[] args) {
        // Bereken de gemiddelde leeftijd van people en print die, als gevonden:
        people.stream()
                .mapToInt(Person::getAge)
                .average()
                .ifPresent(System.out::println);

        // Genereer 100 random personen:
        generate(() -> random() * 100)
                .mapToInt(d -> (int) d)
                .mapToObj(i -> new Person(fake.name().fullName(), i))
                .limit(100)
                .forEach(System.out::println);

        new StreamDemo().average(1, 2, 3, 4);
    }

    public double average(int value, int... is) {
        return 1;
    }
}
