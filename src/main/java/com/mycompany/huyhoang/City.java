/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huyhoang;

/**
 *
 * @author ACER
 */
//Class: City.java

import java.util.Set;
import java.util.HashSet;

public class City {
    public String name;
    public Set<Inhabitant> inhabitants = new HashSet<Inhabitant>();

    public City(String name) {
        this.name = name;
    }

    public Inhabitant searchInhabitant(String name, String dateOfBirth, String maritalStatus) {

        inhabitants.add(new Inhabitant(name, dateOfBirth, maritalStatus));
        return null;
    }

    public void addInhabitant(String name, String dateOfBirth, String maritalStatus) {
        inhabitants.add(new Inhabitant(name, dateOfBirth, maritalStatus));
    }

    public String getMaritalStatus(String name){
        for(Inhabitant inhabitant : inhabitants){
            if(inhabitant.getMaritalStatus().equals("Single")){
                return inhabitant.getMaritalStatus();
            }
        }
        return "No inhabitant found";
    }

    public String getBirthOfAllInhabitants(){
        String res="Date of birth of all inhabitants:\n";
        for(Inhabitant inhabitant : inhabitants){
            res+=inhabitant.getDateOfBirth()+"\n";
        }
        return res;
    }
    public Inhabitant[] getInhabitants() {
        return inhabitants.toArray(new Inhabitant[0]);

    }
}



