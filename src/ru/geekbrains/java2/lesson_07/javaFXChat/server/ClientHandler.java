package ru.geekbrains.java2.lesson_07.javaFXChat.server;
// видео 1:39
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/auth")) {
                            String[] authData = msg.split("\\s");
                            if(authData[1].equals("login") && authData[2].equals("pass")){
                                sendMessage("/authok");
                                break;
                            }
                        }
                    }
                    while (true) {
                        String msg = in.readUTF();
                        System.out.println("from client: " + msg);
                        if (msg.equals("/end")) break;
                        server.broadcastSender("client: " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
