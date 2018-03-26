package ru.geekbrains.java2.lesson_01;

public class Course {
    private Obstacle[] obstacles;

    public Course() {
        obstacles = new Obstacle[]{new Cross(), new Wall(), new Swim()};
    }

    public void doIt(Team team){
        for (Animal a: team.getAnimals()) {
            for (Obstacle o: obstacles) {
                o.doIt(a);
                if (!a.isOnDistance())
                    break;
            }
        }
    }
}
