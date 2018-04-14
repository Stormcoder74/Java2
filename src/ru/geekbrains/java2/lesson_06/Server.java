package ru.geekbrains.java2.lesson_06;

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

            NetTransceiver netTransceiver = new NetTransceiver("Server", socket);
            netTransceiver.start();

            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
