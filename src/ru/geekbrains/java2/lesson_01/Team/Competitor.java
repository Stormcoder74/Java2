package ru.geekbrains.java2.lesson_01.Team;

public interface Competitor {
    void run(int distance);
    void jump(int height);
    void swim(int distance);
    boolean isOnDistance();
    void info();
}
