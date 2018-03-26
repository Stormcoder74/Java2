package ru.geekbrains.java2.lesson_01.Team;

public class Human extends Animal implements Intellect {
    public Human(String name) {
        super("Человек", name, 100, 1, 10);
    }

    @Override
    public int cunning(int i) {
        return i/10;
    }

    @Override
    public void run(int distance) {
        super.run(cunning(distance));
    }

    @Override
    public void jump(int height) {
        super.jump(cunning(height));
    }

    @Override
    public void swim(int distance) {
        super.swim(cunning(distance));
    }
}
