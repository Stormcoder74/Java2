package ru.geekbrains.java2.lesson_01.Course;

import ru.geekbrains.java2.lesson_01.Team.*;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... o) {
        obstacles = o;
    }

    public void doIt(Team team){
        for (Competitor c: team.getCompetitors()) {
            for (Obstacle o: obstacles) {
                o.doIt(c);
                if (!c.isOnDistance())
                    break;
            }
        }
    }
}
