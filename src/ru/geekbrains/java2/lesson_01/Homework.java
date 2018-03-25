package ru.geekbrains.java2.lesson_01;

public class Homework {

    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик"), new Dog("Шарик"),
                new Dolphin("Афалина"), new Human("Вася")};
        Obstacle[] obstacles = {new Cross(), new Wall(), new Swim()};

        for (Animal a: animals) {
            for (Obstacle o: obstacles) {
                o.doIt(a);
                if (!a.isOnDistance())
                    break;
            }
        }
        System.out.println("=========================================\n");
        for (Animal a: animals) {
            a.info();
        }
    }
}
