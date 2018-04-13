package ru.geekbrains.java2.lesson_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected to server...");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            NetListner netListner = new NetListner("Client", inputStream);
            NetSender netSender = new NetSender("Client", outputStream);
            netListner.start();
            netSender.start();
            try {
                netListner.join();
                netSender.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
