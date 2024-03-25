package com.infosupport.mvcdemo.boundary;

import com.infosupport.mvcdemo.domain.Bezorgwijze;
import com.infosupport.mvcdemo.domain.Gebruiker;

import java.util.List;

import static com.infosupport.mvcdemo.App.bwDao;
import static com.infosupport.mvcdemo.App.prompt;
import static com.infosupport.mvcdemo.App.readLine;

public class Registratiescherm implements Boundary {

    // singleton design pattern begin -----------
    private static Registratiescherm self;

    private Registratiescherm() {}

    public static synchronized Registratiescherm registratiescherm() {
        if (self == null) self = new Registratiescherm();
        return self;
    }
    // singleton design pattern end -------------

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Registratie toevoegen]");
            System.out.println("(x) [Terug]");

            switch (readLine()) {
                case "1" -> add();
                case "x" -> {
                    return;
                }
                default -> System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    private void add() {
        String email = prompt("Geef uw e-mailadres: ");

        List<Bezorgwijze> all = bwDao.getAll();
        System.out.println("Bezorgwijzen:");
        for (Bezorgwijze bezorgwijze : all) {
            System.out.println("(" + (bezorgwijze.ordinal() + 1) + ") " + bezorgwijze);
        }

        String bw = prompt("Kies een bezorgwijze (1, 2, 3...)");
        Gebruiker g = Gebruiker.builder().emailadres(email).bezorgwijze(Bezorgwijze.THUIS).build();
        // gebruikerdao.save(g);
        System.out.println("Registratie toegevoegd!");
    }

}
