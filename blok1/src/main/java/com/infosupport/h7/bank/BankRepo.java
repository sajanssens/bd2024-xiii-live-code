package com.infosupport.h7.bank;

import java.util.List;

public class BankRepo {

    public void create(String name) {
        Database.banks.add(new Bank(name));
    }

    public List<Bank> findAll() {
        return Database.banks;
    }

    public List<Bank> findBy(String name) {
        return Database.banks.stream()
                .filter(b -> b.getName().equals(name))
                .toList();
    }

    public void save(Bank b) {
        int i = Database.banks.indexOf(b);
        Database.banks.set(i, b);
    }
}
