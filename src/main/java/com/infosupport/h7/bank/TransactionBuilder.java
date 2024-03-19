package com.infosupport.h7.bank;

public class TransactionBuilder {
    private final Bank bank;
    private Account from;
    private Account to;
    private double amount;

    public TransactionBuilder(Bank bank) {
        this.bank = bank;
    }

    public TransactionBuilder from(Account from) {
        this.from = from;
        return this;
    }

    public TransactionBuilder to(Account to) {
        this.to = to;
        return this;
    }

    public void transfer() {

    }

    public TransactionBuilder amount(double d) {
        this.amount = d;
        return this;
    }
}
