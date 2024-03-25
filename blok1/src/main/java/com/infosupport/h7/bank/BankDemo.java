package com.infosupport.h7.bank;

public class BankDemo {

    public static void main(String[] args) {
        Bank rabo = Database.banks.get(0);
        Account ac1 = Database.accounts.get(0);
        Account ac2 = Database.accounts.get(1);

        // Fluent API:
        rabo.transaction()
                .amount(100.09).from(ac1).to(ac2)
                .transfer();
    }
}

