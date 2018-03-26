package ru.geekbrains.java2.lesson_01;

public class Team {
    private Animal[] animals;

    public Team() {
        animals = new Animal[]{new Cat("Барсик"), new Dog("Шарик"),
                new Dolphin("Афалина"), new Human("Вася")};
    }

    public void showResults(){
        System.out.println("=========================================");
        for (Animal a: animals) {
            a.info();
        }
    }

    public Animal[] getAnimals() {
        return animals;
    }
}
