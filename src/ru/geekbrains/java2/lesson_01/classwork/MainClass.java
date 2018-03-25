package ru.geekbrains.java2.lesson_01.classwork;

import javax.swing.*;

public class MainClass {

    static AppState appState = AppState.INIT;

    public static void main(String[] args) {
        Animal animal = new Cat();
        Flyable fl = new Parrot();

        Duck duck = new Duck();

        fl.fly();
        ((Parrot)fl).voice();

        Predator[] predators = {new Dog(), new Cat(), new Dog()};

        System.out.println(appState.getPriority());
        appState = AppState.SAVE;
        System.out.println(appState.getPriority());

        JButton button = new JButton("Кнопка");
        button.addActionListener(e -> System.out.println("The button clicked!"));
    }


}

