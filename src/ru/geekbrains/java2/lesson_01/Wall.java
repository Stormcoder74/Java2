package ru.geekbrains.java2.lesson_01;

public class Wall extends Obstacle {
    protected int jumpHeight;

    public Wall(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void doIt(Competitor c) {
        c.jump(jumpHeight);
    }
}
