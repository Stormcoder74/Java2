// ВОПРОС: не могу прервать поток, который заблокирован Scanerом, как это можно сделать
// может вместо Scanera чтот-то прерываемое можно использовать
// если можно уделите на уроке этому пару минут пожалуйста

package ru.geekbrains.java2.lesson_06;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class NetTransceiver {
    private String name;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Scanner scanner;
    private Thread listner;
    private Thread sender;

    public NetTransceiver(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
    }

    public void start() {
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        listner = new Thread(new Runnable() {
            @Override
            public void run() {
                String message = "";
                while (!Thread.interrupted()) {
                    try {
                        message = inputStream.readUTF();
                    } catch (IOException e) {
                        System.out.println("program is stopped");
                        break;
                    }
                    System.out.println(message);
                    if (message.contains("/end"))
                        Thread.currentThread().interrupt();
                }
                sender.interrupt();
                scanner.close(); // ни как не могу прервать поток
            }
        });

        sender = new Thread(new Runnable() {
            @Override
            public void run() {
                scanner = new Scanner(System.in);
                String message = "";
                while (!Thread.interrupted()) {
                    message = scanner.nextLine();
                    try {
                        outputStream.writeUTF(name + ": " + message);
                        outputStream.flush();
                    } catch (IOException e) {
                        System.out.println("program is stoped");
                        break;
                    }
                    if (message.contains("/end"))
                        Thread.currentThread().interrupt();
                }
                listner.interrupt();
                try {
                    inputStream.close(); // а этот рвется, правда, на мой взгляд, грубо
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        listner.start();
        sender.start();
        try {
            listner.join();
            sender.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
