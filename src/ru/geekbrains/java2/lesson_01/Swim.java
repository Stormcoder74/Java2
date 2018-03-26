package ru.geekbrains.java2.lesson_01;

public class Swim extends Obstacle {
    protected int swimDistance;

    public Swim(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    @Override
    public void doIt(Competitor c) {
        c.swim(swimDistance);
    }
}
