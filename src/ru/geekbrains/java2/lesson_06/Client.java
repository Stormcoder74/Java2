package ru.geekbrains.java2.lesson_06;

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

            NetTransceiver netTransceiver = new NetTransceiver("Client", socket);
            netTransceiver.start();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
