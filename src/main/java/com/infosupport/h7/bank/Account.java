package com.infosupport.h7.bank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String iban;    // TODO use Iban value type
    private double balance; // TODO use BigDecimal
    private Bank bank;

    public Account(String iban, double balance, Bank bank) {
        this.iban = iban;
        this.balance = balance;
        setBank(bank);
    }

    public void setBank(Bank b) {
        this.bank = b;
        bank.getAccounts().add(this);
    }
}
