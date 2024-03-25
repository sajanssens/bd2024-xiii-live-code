package com.infosupport.h7.bank;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {

    private final String name;
    private List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void add(Account a) {
        this.accounts.add(a);
    }

    public TransactionBuilder transaction() {
        return new TransactionBuilder(this);
    }
}
