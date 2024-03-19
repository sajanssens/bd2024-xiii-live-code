package com.infosupport.h7.bank;

public class BankDemo {

    public static void main(String[] args) {
        Bank rabo = new Bank();
        Account ac1 = new Account();
        Account ac2 = new Account();

        // Fluent API:
        rabo.transaction()
                .amount(100.09).from(ac1).to(ac2)
                .transfer();
    }
}

