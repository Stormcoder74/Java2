package ru.geekbrains.java2.lesson_01;

public class Homework {

    public static void main(String[] args) {
        Course c = new Course();
        Team team = new Team();

        c.doIt ( team );
        team.showResults();
    }
}
