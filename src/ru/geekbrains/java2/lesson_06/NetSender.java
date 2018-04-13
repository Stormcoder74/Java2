package ru.geekbrains.java2.lesson_06;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class NetSender extends Thread {
    private DataOutputStream outputStream;

    public NetSender(String name, DataOutputStream outputStream) {
        super(name);
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message = "";
        do{
            message = scanner.nextLine();
            try {
                outputStream.writeUTF(Thread.currentThread().getName() + ": " + message);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }while (!message.equals("/end"));
    }
}
