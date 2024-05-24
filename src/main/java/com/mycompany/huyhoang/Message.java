/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huyhoang;

/**
 *
 * @author ACER
 */
//Class: Message: 

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
    public String city;
    public String method_name;
    public Object[] params;
    public String getCity(){
        return city;
    }

    public Message(String city, String method_name, Object[] params){
        this.city = city;
        this.method_name = method_name;
        this.params = params;

    }
}