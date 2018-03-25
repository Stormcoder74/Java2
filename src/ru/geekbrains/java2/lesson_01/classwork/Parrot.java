package ru.geekbrains.java2.lesson_01.classwork;

import ru.geekbrains.java2.lesson_01.classwork.Animal;
import ru.geekbrains.java2.lesson_01.classwork.Flyable;

public class Parrot extends Animal implements Flyable {

    @Override
    public void fly() {

    }

    @Override
    public void landing() {

    }

    public void voice(){
        System.out.println("Попка дурррак");
    }
}
