package ru.geekbrains.java2.lesson_04;

import javax.swing.*;
import java.awt.*;

public class HintTextField extends JTextField {
    private String hint;

    public HintTextField(int columns, String hint) {
        super(30);
        this.hint = hint;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty()){
            g.setColor(new Color(0x737EFF));
            g.drawString(hint, 2, 22);
        }
    }
}
