package ru.geekbrains.java2.lesson_01;

public class Cross extends Obstacle {
    @Override
    public void doIt(Competitor c) {
        c.run(runDistance);
    }
}
