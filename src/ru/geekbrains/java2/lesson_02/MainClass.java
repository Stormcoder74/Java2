package ru.geekbrains.java2.lesson_02;

import javafx.scene.media.SubtitleTrack;

public class MainClass {
    public static void main(String[] args) {
        a();
    }

    static void a() {
        b();
    }

    static void b() {
        c();
    }

    static void c() {
        System.out.println("START");
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("AE");
            return;
        } finally {
            System.out.println("FINALLY");
        }
        System.out.println("END");
    }
}
