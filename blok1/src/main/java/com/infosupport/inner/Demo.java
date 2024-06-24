package com.infosupport.inner;

public class Demo {

    public static void main(String[] args) {
        // fqn.vh.type id = new fqn.vh.type();
        Schot kilt = new Schot();
        Schot.Doedelzak d = new Schot.Doedelzak();

        Schot.Kilt schot = new Schot().new Kilt();
    }
}

class Schot {

    // instance stuff ==============================
    //   - field(s)
    private int kleur;
    //   - methods
    void dance() {
        // this.kleur = 0;
    }
    //   - class(es)
    class Kilt {
        private int kleur;

        void wash() {
            this.kleur = 0; // kleur van Kilt
            Schot.this.kleur = 0; // kleur van Schot
        }
    }

    // static stuff ================================
    //   - field(s)
    private static int lengte = 34;
    //   - methods
    static void beIndependent(String y) {
        // this.kleur = 0;
    }
    //   - class(es)
    static class Doedelzak {
        void x() {
            lengte = 42;
        }
    }

}

class Doedelzak {
    void x() {
        // Schot.lengte = 42;
    }
}
