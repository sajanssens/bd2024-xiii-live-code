package com.infosupport.h7.bank;

import java.util.Arrays;
import java.util.List;

public class Database {

    private static final Bank rabo = new Bank("Rabo");
    private static final Bank abn = new Bank("ABN");

    public static final List<Bank> banks = Arrays.asList(rabo, abn);

    public static final List<Account> accounts = Arrays.asList(
            new Account("ABC", 100, rabo),
            new Account("XYZ", 200, rabo),
            new Account("DEF", 300, abn)
    );
}
