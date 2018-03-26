package ru.geekbrains.java2.lesson_01;

public class Cross extends Obstacle {
    protected int runDistance;

    public Cross(int runDistance) {
        this.runDistance = runDistance;
    }

    @Override
    public void doIt(Competitor c) {
        c.run(runDistance);
    }
}
