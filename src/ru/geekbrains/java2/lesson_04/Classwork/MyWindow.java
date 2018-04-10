package ru.geekbrains.java2.lesson_04.Classwork;
// video 2:17
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyWindow extends JFrame {
    private JTextField textField;
    private JTextArea textArea;

    public MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My application");
        setBounds(750, 250, 400, 445);

        Font arial18 = new Font("Arial", Font.BOLD, 18);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        textField = new MyHintTextfield(32, "Введите сообщение");
        textField.setFont(arial18);
        textField.setPreferredSize(new  Dimension(250, 40));
        JPanel upPanel = new JPanel(new BorderLayout());

        upPanel.add(button1, BorderLayout.WEST);
        upPanel.add(textField, BorderLayout.CENTER);
        upPanel.add(button2, BorderLayout.EAST);
        add(upPanel, BorderLayout.NORTH);

        JList<String> membersList = new JList<>(new DefaultListModel<>());
        add(membersList, BorderLayout.EAST);
        membersList.setPreferredSize(new Dimension(100, 1));
        ((DefaultListModel<String>)membersList.getModel()).addElement("member1");
        ((DefaultListModel<String>)membersList.getModel()).addElement("abrakadabra");
        ((DefaultListModel<String>)membersList.getModel()).addElement("noNickName");

        textArea = new JTextArea(20, 32);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(arial18);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        button1.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Перегрев процессора", "Внимание!!!", JOptionPane.WARNING_MESSAGE));
        button2.addActionListener(e -> sendMsg());
        textField.addActionListener(e -> sendMsg());

       button1.addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               super.mouseDragged(e);
               button1.setBackground(new Color(0xAC2521));
           }

           @Override
           public void mouseMoved(MouseEvent e) {
               super.mouseMoved(e);
               button1.setBackground(new Color(0x0AAC1A));
           }
       });

        setVisible(true);
    }

    public void sendMsg() {
        String meggage = textField.getText();
        if (!meggage.isEmpty()) {
            textArea.append(textField.getText() + "\n");
            textField.setText("");
        }
        textField.grabFocus();
    }
}
