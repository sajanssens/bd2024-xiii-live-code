package com.infosupport.h4;

import java.io.IOException;

public class ExceptionsDemo {

    public static void main(String[] args) {
        // try {
        //     int i = Integer.parseInt("één");
        // } catch (NumberFormatException e) {
        //     // opeten = slecht idee
        //     // loggen is sowieso goed
        //     // wat ga je nu doen? bijv.:
        //     System.out.println("gast, type iets goeds in, OUTLAW!!");
        //     throw new RuntimeException("", e);
        // }
        //
        // WaterBron w = null;
        // try {
        //     w = new WaterBron();
        //     w.stroom();
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // } finally {
        //     try {
        //         w.close();
        //     } catch (IOException e) {
        //         throw new RuntimeException(e);
        //     }
        // }

        try (WaterBron w2 = new WaterBron()) {
            w2.stroom();
        }
        // catch (HetWaterIsOpException e) {
        //     System.out.println("Er ging iets fout met de waterbron:");
        //     System.out.println(e.getMessage());
        // }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
