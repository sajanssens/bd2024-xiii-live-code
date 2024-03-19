package com.infosupport.h7.bank;

public class Bank {
    public TransactionBuilder transaction() {
        return new TransactionBuilder(this);
    }
}
