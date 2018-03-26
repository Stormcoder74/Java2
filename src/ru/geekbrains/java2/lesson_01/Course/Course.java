package ru.geekbrains.java2.lesson_01.Course;

import ru.geekbrains.java2.lesson_01.Team.*;

public class Course {
    private Obstacle[] obstacles;

    public Course() {
        obstacles = new Obstacle[]{new Cross(150), new Wall(5), new Swim(20)};
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
