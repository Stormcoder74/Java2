package ru.geekbrains.java2.lesson_01;

public class Wall extends Obstacle {
    @Override
    public void doIt(Competitor c) {
        c.jump(jumpHeight);
    }
}
