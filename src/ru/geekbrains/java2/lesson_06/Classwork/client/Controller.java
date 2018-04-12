package ru.geekbrains.java2.lesson_06.Classwork.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8189;

    @FXML
    public TextArea chatArea;
    @FXML
    public TextField msgField;
//    public Button sendButton;

    private Socket socket;
    private DataOutputStream out;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Thread(() -> {
                String msg = "";
                try {
                    while (!msg.equals("echo answer: /end")) {
                        msg = in.readUTF();
                        chatArea.appendText(msg + "\n");
                    }
                    chatArea.appendText("соединение разорвано\n");
                } catch (IOException e) {
                    System.err.println("Сервер рвзорвал соединение");
                    e.printStackTrace();
//                            System.exit(0);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.setDaemon(true);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        if (!msgField.getText().equals(""))
            try {
                out.writeUTF(msgField.getText());
                out.flush();
                msgField.clear();
                msgField.requestFocus();
            } catch (IOException e) {
                chatArea.appendText("нет связи с сервером\n");
            }
    }

}

