package com.infosupport.h7.mvcexample;

import com.infosupport.h7.mvcexample.boundary.Hoofdscherm;
import com.infosupport.h7.mvcexample.dao.BezorgwijzeDao;

import java.util.Scanner;

public class App {

    public static final BezorgwijzeDao bwDao = new BezorgwijzeDao();
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() { return scanner.nextLine(); }

    public static String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static void main(String[] args) { new Hoofdscherm().start(); }

}
