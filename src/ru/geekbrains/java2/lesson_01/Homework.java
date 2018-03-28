// https://github.com/Stormcoder74/Java2.git
package ru.geekbrains.java2.lesson_01;

import ru.geekbrains.java2.lesson_01.Course.*;
import ru.geekbrains.java2.lesson_01.Team.*;

public class Homework {
    public static void main(String[] args) {
        Course c = new Course(new Cross(150), new Wall(5), new Swim(20));
        Team team = new Team(new Cat("Барсик"), new Dog("Шарик"),
                new Dolphin("Афалина"), new Human("Вася"));

        c.doIt(team);
        team.showResults();
    }
}
