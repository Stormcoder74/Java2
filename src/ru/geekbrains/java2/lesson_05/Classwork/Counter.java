package ru.geekbrains.java2.lesson_05.Classwork;

public class Counter {
    private int c;

    public Counter() {
        c = 0;
    }

    public int value() {
        return c;
    }

    public synchronized void inc() {
        c++;
    }

    public synchronized void dec(){
        c--;
    }
}
