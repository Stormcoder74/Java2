package ru.geekbrains.java2.lesson_06;

import java.io.DataInputStream;
import java.io.IOException;

public class NetListner extends Thread {
    private DataInputStream inputStream;

    public NetListner(String name, DataInputStream inputStream) {
        super(name);
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        String message = "";
        do{
            try {
                message = inputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            System.out.println(message);
        }while (!message.contains("/end"));
    }
}
