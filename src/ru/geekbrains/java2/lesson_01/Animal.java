package ru.geekbrains.java2.lesson_01;

public abstract class Animal implements Competitor {
    private String type;
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;
    private boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        onDistance = true;
    }

    public void info(){
        System.out.printf("%s %s : %b\n", type, name, onDistance);
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void run(int distance) {
        if(distance > maxRunDistance){
            System.out.printf("%s %s не смог преодолеть дистанцию\n", type, name);
            onDistance = false;
            return;
        }
        System.out.printf("%s %s успешно преодолел дистанцию\n", type, name);
    }

    @Override
    public void jump(int height) {
        if(height > maxJumpHeight){
            System.out.printf("%s %s не смог перепрыгнуть стену\n", type, name);
            onDistance = false;
            return;
        }
        System.out.printf("%s %s успешно перепрыгнул стену\n", type, name);
    }

    @Override
    public void swim(int distance) {
        if(distance > maxSwimDistance){
            System.out.printf("%s %s не смог проплыть дистанцию\n", type, name);
            onDistance = false;
            return;
        }
        System.out.printf("%s %s успешно проплыл дистанцию\n", type, name);
    }
}
