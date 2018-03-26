package ru.geekbrains.java2.lesson_01.Course;

import ru.geekbrains.java2.lesson_01.Team.*;

public class Wall extends Obstacle {
    private int jumpHeight;

    public Wall(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void doIt(Competitor c) {
        c.jump(jumpHeight);
    }
}
