// https://github.com/Stormcoder74/Java2.git
package ru.geekbrains.java2.lesson_01;

import ru.geekbrains.java2.lesson_01.Course.Course;
import ru.geekbrains.java2.lesson_01.Team.Team;

public class Homework {
    public static void main(String[] args) {
        Course c = new Course();
        Team team = new Team();

        c.doIt(team);
        team.showResults();
    }
}
