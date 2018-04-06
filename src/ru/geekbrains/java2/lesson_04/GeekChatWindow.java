package ru.geekbrains.java2.lesson_04;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeekChatWindow extends JFrame {
    private HintTextField nicknameField;
    private HintTextField messageField;
    private JTextArea chatArea;
    private JList<String> membersList;

    public GeekChatWindow(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(750, 150, 500, 800);
        Font arial18 = new Font("Arial", Font.PLAIN, 18);

        JLabel nickLable = new JLabel("Никнейм:  ");
        nickLable.setFont(arial18);

        nicknameField = new HintTextField(28, "Введите ваш ник");
        nicknameField.setFont(arial18);
        nicknameField.setPreferredSize(new Dimension(1, 32));

        JPanel nickPanel = new JPanel(new BorderLayout());
        nickPanel.setBorder(new EmptyBorder(3, 5, 2, 5));
        nickPanel.add(nickLable, BorderLayout.WEST);
        nickPanel.add(nicknameField, BorderLayout.CENTER);
        add(nickPanel, BorderLayout.NORTH);

        messageField = new HintTextField(30, "Введите сообщение");
        messageField.setFont(arial18);
        messageField.setPreferredSize(new Dimension(1, 32));
        messageField.addActionListener(new SendMessage());

        JButton sendButton = new JButton("Отправить");
        sendButton.setFont(arial18);
        sendButton.addActionListener(new SendMessage());

        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(new EmptyBorder(2, 5, 2, 5));
        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);
        add(messagePanel, BorderLayout.SOUTH);

        chatArea = new JTextArea(20, 30);
        chatArea.setFont(arial18);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setEditable(false);
        chatArea.append("member1: добрый вечер всем, а в чём суть Дз?\n" +
                "там же есть готовый код уже, на уроке проходили, просто самому разобраться и переписать?\n\n" +
                "abrakadabra : Добрый. Именно так\n\n" +
                "noNickName: Вообще по заданию ДЗ окно чата выглядеть должно немного иначе.\n\n");

        JScrollPane chatScroller = new JScrollPane(chatArea);
        add(chatScroller, BorderLayout.CENTER);

        membersList = new JList<>(new DefaultListModel<>());
        membersList.setPreferredSize(new Dimension(100, 1));
        ((DefaultListModel<String>) membersList.getModel()).addElement("member1");
        ((DefaultListModel<String>) membersList.getModel()).addElement("abrakadabra");
        ((DefaultListModel<String>) membersList.getModel()).addElement("noNickName");

        JLabel membersLable = new JLabel("Участники:");

        JPanel membersPanel = new JPanel(new BorderLayout());
        membersPanel.setBorder(new EmptyBorder(4, 4, 4, 4));
        membersPanel.add(membersLable, BorderLayout.NORTH);
        membersPanel.add(membersList, BorderLayout.CENTER);

        JScrollPane memberScroller = new JScrollPane(membersPanel);
        add(memberScroller, BorderLayout.EAST);


        setVisible(true);
    }

    class SendMessage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!messageField.getText().isEmpty()) {
                String nickname = nicknameField.getText();

                if (nickname.isEmpty()) nickname = "unknown";
                else if (!((DefaultListModel<String>) membersList.getModel()).contains(nicknameField.getText()))
                    ((DefaultListModel<String>) membersList.getModel()).addElement(nicknameField.getText());

                chatArea.append(nickname + ": " + messageField.getText() + "\n\n");
                messageField.setText("");
                messageField.grabFocus();
            }
        }
    }
}
