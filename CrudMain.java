package com.eu.modris;

import java.util.Scanner;

public class CrudMain {

    public static void main(String[] args) {


        com.eu.modris.CrudLogic crudLogic = new com.eu.modris.CrudLogic();

        Scanner scanner = new Scanner(System.in);

//        crudLogic.insert();
//        crudLogic.select();
//        crudLogic.delete();
//        crudLogic.update();

        boolean quit = false;
        while (!quit) {

            System.out.println("Izvēlies vienu burtu: 1) i, 2) s, 3) d, 4) u");

            String user = scanner.nextLine();

            System.out.println("Tu izvēlējies: " + user);

            switch (user) {
                // te izmantoju IntelliJ ieteikumu noformēt switch šādi
                case "s" -> crudLogic.select();
                case "i" -> crudLogic.insert();
                case "u" -> crudLogic.update();
                case "d" -> crudLogic.delete();
                case "q" -> {
                    quit = true;
                    System.out.println("Uz redzēšanos!");
                }
                default -> System.out.println("Nepareiza izvēle!");
            }
        }
    }
}
