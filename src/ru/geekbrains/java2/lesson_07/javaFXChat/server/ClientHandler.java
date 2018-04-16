package ru.geekbrains.java2.lesson_07.javaFXChat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/auth")) {
                            String[] authData = msg.split("\\s");

                            String newNick = null;

                            // fix bug (отправка пустых логина и пароля приводит к выходу за границы массива)
                            if (authData.length == 3)
                                newNick = server.getAuthService().getNickByLoginAndPass(authData[1], authData[2]);
                            if (newNick != null) {
                                nick = newNick;
                                sendMessage("/authok");
                                server.subscribe(this);
                                break;
                            } else {
                                sendMessage("Неверный логин/пароль");
                            }
                        }
                    }
                    while (true) {
                        String msg = in.readUTF();
                        System.out.println(nick + ": " + msg);

                        if (msg.startsWith("/w")) {
                            int firstSpace = msg.indexOf(" ") + 1;   // почему здесь не работает \\s ?
                            int secondSpace = msg.indexOf(" ", firstSpace);
                            String destNick = msg.substring(firstSpace, secondSpace);
                            String privateMsg = msg.substring(secondSpace);
                            server.privateSender(nick, destNick, privateMsg);
                            continue;
                        }
                        if (msg.equals("/end")) break;
                        server.broadcastSender(nick + ": " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
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

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
