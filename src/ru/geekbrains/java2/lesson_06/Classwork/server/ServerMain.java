package ru.geekbrains.java2.lesson_06.Classwork.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server started...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream scanner = new DataInputStream(socket.getInputStream());
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String msg = "";
            while (!msg.equals("/end")) {
                msg = scanner.readUTF();
                System.out.println("Client said: " + msg);
                writer.writeUTF("echo answer: " + msg);
                writer.flush();
            }
            System.out.println("Command for disconnect");
            socket.close();
            System.out.println("Server stopped...");
        } catch (IOException e) {
            System.err.println("Потеря связи");
            e.printStackTrace();
        }

    }
}
