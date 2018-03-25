package ru.geekbrains.java2.lesson_01.classwork;

public enum AppState {
    INIT(2), PREPARE(4), WORK(5), SAVE(10), TERINATE(1);
    private int priority;

    private AppState(int priority) {
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }
}
