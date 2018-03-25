package ru.geekbrains.java2.lesson_01.classwork;

public interface Swimable {
    void swim();
    void landing();

    default void defaultFly(){

    }
}
