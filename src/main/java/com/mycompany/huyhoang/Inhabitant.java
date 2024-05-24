/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huyhoang;

/**
 *
 * @author ACER
 */
//Class: Inhabitant

//package src;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Date;

public class Inhabitant implements java.io.Serializable{
    public String name;
    public String dateOfBirth;
    public String maritalStatus;

    public Inhabitant(String name, String dateOfBirth, String maritalStatus) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String ChangeMaritalStatus(String newStatus){
        this.maritalStatus = newStatus;
        return "Marital status changed";
    }
}


