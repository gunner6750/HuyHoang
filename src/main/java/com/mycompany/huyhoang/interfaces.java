/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.huyhoang;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author ACER
 */
public interface interfaces extends Remote{
    void addInhabitant(String name,String dateOfBirth,String maritalStatus) throws RemoteException;
    String allBirth() throws RemoteException;
    String marialStatus(String name) throws RemoteException;
    
}
