package ru.geekbrains.java2.lesson_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 8189;
    public static void main(String[] args) {
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started...");
            socket = serverSocket.accept();
            System.out.println("Client connected...");
//            serverSocket.close();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            NetListner  netListner = new NetListner("Server", inputStream);
            NetSender netSender = new NetSender("Server", outputStream);
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
