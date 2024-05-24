/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huyhoang;

/**
 *
 * @author ACER
 */
//UDP Server: 

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.rmi.RemoteException;

public class UDPServer1 implements interfaces{
        public static byte[] buffer = new byte[1024];
        private static City city = new City("Berlin");
        @Override
        public void addInhabitant(String name,String dateOfBirth,String maritalStatus) throws RemoteException{
            return;
        }
        @Override
        public String allBirth() throws RemoteException{
            return "";
        }
        @Override
        public String marialStatus(String name) throws RemoteException{
            return "";
        }
        public static void main(String[] args) {
            //create socket with port 12345
            try (DatagramSocket socket = new DatagramSocket(12345)) {
                //create buffer used to store data of received UDP packet
                
                //main loop for receiving and processing packets
                while (true) {
                    
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
                    ObjectInputStream ois = new ObjectInputStream(bais);
                    Message message = (Message) ois.readObject();

                    Object result = handleMessage(message);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(baos);
                    oos.writeObject(result);
                    byte[] responseBytes = baos.toByteArray();

                    DatagramPacket responsePacket = new DatagramPacket(
                            responseBytes, responseBytes.length, packet.getAddress(), packet.getPort());
                    socket.send(responsePacket);
                }
            } catch (SocketException e){System.out.println("Socket: " + e.getMessage());
            } catch (IOException e){System.out.println("IO: " + e.getMessage());

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        private static Object handleMessage(Message message) {
            String methodName = message.method_name;
            Object[] params = message.params;
            if (methodName.equals("addInhabitant")) {
                city.addInhabitant((String) params[0], (String) params[1], (String) params[2]);
                return "Inhabitant added";
            } else if (methodName.equals("getMaritalStatus")) {
                return city.getMaritalStatus((String) params[0]);
            } else if (methodName.equals("getBirth")){
            }
            return "Unknown method";
        }
    }