package ru.geekbrains.java2.lesson_04.Classwork;
// video 1:37
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private JTextField textField;
    private JTextArea textArea;

    public MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My application");
        setBounds(750, 250, 400, 445);

        setLayout(new FlowLayout());
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
//        button1.setPreferredSize(new Dimension(1, 40));
        add(button1);
        add(button2);

        textField = new JTextField(32);
        add(textField);


        textArea = new JTextArea(20, 32);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        button1.addActionListener(e -> System.out.println("Button 1 clicked!"));
        button2.addActionListener(e -> sendMsg());
        textField.addActionListener(e -> sendMsg());

        /*for (int i=0; i<70; i++){
            JButton jb = new JButton("jb"+i);
            add(jb);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Clicked " + jb.getText());
                }
            });
        }*/

        setVisible(true);
    }

    public void sendMsg() {
        textArea.append(textField.getText() + "\n");
        textField.setText("");
        textField.grabFocus();
    }
}
