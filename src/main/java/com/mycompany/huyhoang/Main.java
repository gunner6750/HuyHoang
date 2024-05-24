/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huyhoang;

/**
 *
 * @author ACER
 */
//CLass: Main.java

import java.io.Serial;
import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

import java.util.Scanner;

public class Main implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        City frankfurt = new City("Frankfurt");
        frankfurt.addInhabitant("hoang", "08-06-2003", "Single");
        frankfurt.addInhabitant("phi", "07-03-2003", "Married");
        frankfurt.addInhabitant("bao", "31-12-2003", "Single");

        City berlin = new City("Berlin");
        berlin.addInhabitant("tammy", "21-03-2003", "Married");
        berlin.addInhabitant("huy", "12-06-2003", "Single");
        berlin.addInhabitant("hieu", "01-01-2003", "Married");

        int unMarriedcountinfrankfurt = 0;
        int unMarriedcountinberlin = 0;
        for (Inhabitant inhabitant : frankfurt.getInhabitants()) {
            if (inhabitant.getMaritalStatus().equals("Single")) {
                unMarriedcountinfrankfurt++;
            }
            else if (inhabitant.getMaritalStatus().equals("Single")) {
                unMarriedcountinberlin++;
            }

        }

        System.out.println("Number of inhabitants in Frankfurt: " + frankfurt.getInhabitants().length);
        System.out.println("Number of inhabitants in Berlin: " + berlin.getInhabitants().length);

        System.out.println("Number of unmarried inhabitants: " + unMarriedcountinfrankfurt);

        Scanner scanner = new Scanner(System.in);
        System.out.println("which city do you want to search for an inhabitant? (Frankfurt/Berlin)");
        String cityName = scanner.nextLine();
        City city = cityName.equals("Frankfurt") ? frankfurt : berlin;


        System.out.println("Enter the name of the inhabitant you want to search: ");
        String name = scanner.nextLine();
        System.out.println("Enter the date of birth of the inhabitant you want to search: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter the marital status of the inhabitant you want to search: ");
        String maritalStatus = scanner.nextLine();

        Inhabitant searchedInhabitant = frankfurt.searchInhabitant(name, dateOfBirth, maritalStatus);
        if (searchedInhabitant != null) {
            System.out.println("Inhabitant found: " + searchedInhabitant.getName());
        } else {
            System.out.println("Inhabitant not found");
        }
    }
}