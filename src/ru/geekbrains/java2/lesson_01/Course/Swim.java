package ru.geekbrains.java2.lesson_01.Course;

import ru.geekbrains.java2.lesson_01.Team.*;

public class Swim extends Obstacle {
    private int swimDistance;

    public Swim(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    @Override
    public void doIt(Competitor c) {
        c.swim(swimDistance);
    }
}
