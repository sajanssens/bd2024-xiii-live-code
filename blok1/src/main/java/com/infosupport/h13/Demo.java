package com.infosupport.h13;

import com.infosupport.h7.Human;
import com.infosupport.h7.Person;

import java.util.ArrayList;
import java.util.List;

import static com.infosupport.h13.Util.verwerkSafeContravariant;
import static com.infosupport.h13.Util.verwerkSafeCovariant;
import static com.infosupport.h13.Util.verwerkSafeInvariant;
import static com.infosupport.h13.Util.verwerkSafeRaw;
import static com.infosupport.h13.Util.verwerkUnsafeRaw;

public class Demo {

    // Generics = Generic types
    public static void main(String[] args) {
        List personenUnsafe = new ArrayList();
        personenUnsafe.add(new Person("Bram", 44));
        personenUnsafe.add(new Person("Leon", 24));
        personenUnsafe.add("Corne");

        verwerkSafeRaw(personenUnsafe);
        verwerkUnsafeRaw(personenUnsafe);

        List<Person> personenSafe = new ArrayList<>();
        personenSafe.add(new Person("Bram", 44));
        personenSafe.add(new Person("Leon", 24));
        // personenSafe.add("Corne"); // NOK

        verwerkSafeRaw(personenSafe);
        verwerkUnsafeRaw(personenSafe);
        verwerkSafeInvariant(personenSafe);

        verwerkSafeInvariant(new Person("Bram", 44));
        verwerkSafeInvariant(new Trainee());

        List<Trainee> trainees = new ArrayList<>();
        trainees.add(new Trainee());

        // call site (argument)
        verwerkSafeCovariant(trainees);

        List<Human> humans = new ArrayList<>();
        verwerkSafeContravariant(humans);
    }


}
