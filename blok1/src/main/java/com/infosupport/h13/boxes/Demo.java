package com.infosupport.h13.boxes;

import com.infosupport.h7.Human;
import com.infosupport.h7.Person;

import java.util.ArrayList;
import java.util.List;

import static com.infosupport.h13.boxes.Util.addPersonTo;
import static com.infosupport.h13.boxes.Util.addTo;
import static com.infosupport.streams.StreamDemo.people;

public class Demo {
    public static void main(String[] args) {
        BoxInt intBox = new BoxInt(1);

        // use site: `Person` is called "type argument"
        Box<Person> personBox = new Box<>(new Person()); // type inference
        Box<String> stringBox = new Box<>("new Person()"); // type inference

        Person personBoxContents = personBox.getContents();
        String stringBoxContents = stringBox.getContents();

        List<String> strings = new ArrayList<>();
        List<Human> humans = new ArrayList<>();

        addPersonTo(people, new Person());
        addTo(people, new Person());
        addTo(humans, new Person());
        addTo(strings, "new Person()");
    }
}
