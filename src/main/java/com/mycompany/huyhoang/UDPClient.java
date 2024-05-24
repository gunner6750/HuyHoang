/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huyhoang;

/**
 *
 * @author ACER
 */
//Class: UDP Client: 

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import java.net.*;
import java.io.*;
import org.apache.commons.lang3.SerializationUtils;
public class UDPClient {
    public static void main(String[] args) {
        try {
            String method1="addInhabitant";
            String method2="getMaritalStatus";
            String method3="BirthOfAllInhabitants";
            String[] param1={"God","10-2-2002","Single"};
            String[] param2={"tammy"};
            String[] param3={};
            String city1="Berlin";
            String city2="Frankfurt";
            Message message=new Message(city1, method3, param3);
            DatagramSocket aSocket = new DatagramSocket();
            byte[] m = SerializationUtils.serialize(message);
            InetAddress aHost = InetAddress.getByName("localhost");
            int serverPort = 12345;
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket.send(request);

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println(" Reply: " + new String(reply.getData()));
            aSocket.close();
        } catch (SocketException e) {
            System.out.println(" Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" IO: " + e.getMessage());
        }
    }
}
