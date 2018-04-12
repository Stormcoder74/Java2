package ru.geekbrains.java2.lesson_06.Classwork.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server started...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            String msg = "";
            while (!msg.equals("/end")) {
                msg = scanner.nextLine();
                System.out.println("Client said: " + msg);
                writer.println("echo answer: " + msg);
                writer.flush();
            }
            System.out.println("Command for disconnect");
            socket.close();
            System.out.println("Server stopped...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
