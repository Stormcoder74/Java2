package ru.geekbrains.java2.lesson_01;

public abstract class Obstacle {
    protected static int runDistance;
    protected static int jumpHeight;
    protected static int swimDistance;

    public Obstacle() {
        runDistance = 150;
        jumpHeight = 5;
        swimDistance = 20;
    }

    public abstract void doIt(Competitor c);
}
