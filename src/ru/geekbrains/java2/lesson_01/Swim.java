package ru.geekbrains.java2.lesson_01;

public class Swim extends Obstacle {
    @Override
    public void doIt(Competitor c) {
        c.swim(swimDistance);
    }
}
