package ru.geekbrains.java2.lesson_07.javaFXChat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clientList;

    public Server(int port) {
        clientList = new Vector<>();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started...Waiting for clients");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected" +
                        socket.getInetAddress() + ":" +
                        socket.getPort() + ":" +
                        socket.getLocalPort());
                clientList.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastSender(String message) {
        for (ClientHandler ch :
                clientList) {
            ch.sendMessage(message);
        }
    }
}
