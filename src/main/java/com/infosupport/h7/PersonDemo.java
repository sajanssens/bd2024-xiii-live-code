package com.infosupport.h7;

public class PersonDemo {

    public static void main(String[] args) {
        PersonDemo demo = new PersonDemo();
        demo.personDemo();
    }

    public void personDemo() {
        final Person p = new Person();
        p.setName("Bram"); // still allowed though p is final!
        changeName(p);
        System.out.println(p);

        Laptop hp1234 = new Laptop();
        hp1234.setBrand("HP");
        hp1234.setPrice(600.89);
        p.setDbo(hp1234);

        p.setDwb(new Laptop(999));

        p.fit(new Shoe(42, ""));
        p.fit(new Shoe(44, ""));
        p.fit(new Shoe(41, ""));

        System.out.println(p);
    }

    public void changeName(Person eenPerson) {
        eenPerson.setName("Gijs");
    }
}

