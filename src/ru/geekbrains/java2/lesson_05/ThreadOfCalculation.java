package ru.geekbrains.java2.lesson_05;

public class ThreadOfCalculation implements Runnable {
    private float arr[];
    private int offset;

    public ThreadOfCalculation(float[] arr, int offset) {
        this.arr = arr;
        this.offset = offset;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            int j = i + offset;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }
}
