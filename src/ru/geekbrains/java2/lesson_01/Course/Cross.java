package ru.geekbrains.java2.lesson_01.Course;

import ru.geekbrains.java2.lesson_01.Team.*;

public class Cross extends Obstacle {
    private int runDistance;

    public Cross(int runDistance) {
        this.runDistance = runDistance;
    }

    @Override
    public void doIt(Competitor c) {
        c.run(runDistance);
    }
}
