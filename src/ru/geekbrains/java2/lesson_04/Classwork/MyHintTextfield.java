package ru.geekbrains.java2.lesson_04.Classwork;

import javax.swing.*;
import java.awt.*;

public class MyHintTextfield extends JTextField {
    private String hint;

    public MyHintTextfield(int columns, String hint) {
        super(columns);
        this.hint = hint;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(getText().isEmpty() && !hasFocus()){
            g.drawString(hint, 2, 26);
        }
    }
}
