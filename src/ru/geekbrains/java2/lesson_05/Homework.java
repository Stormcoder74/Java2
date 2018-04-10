package ru.geekbrains.java2.lesson_05;

import java.util.Arrays;

public class Homework {
    static final int size = 10000000;

    public static void main(String[] args) {
        long startTime;

        float[] arr = new float[size];
        Arrays.fill(arr, 1f);

        startTime = System.currentTimeMillis();
        MonothreadedCalculate.calc(arr.clone());
        System.out.println("Вычисление в однопоточном методе заняло " +
                (float) (System.currentTimeMillis() - startTime) / 1000 + " сек.");

        startTime = System.currentTimeMillis();
        TwothreadedCalculate.calc(arr.clone());
        System.out.println("Вычисление в двухпоточном методе заняло " +
                (float) (System.currentTimeMillis() - startTime) / 1000 + " сек.");

        startTime = System.currentTimeMillis();
        MultithreadedCalculate.calc(arr.clone());
        System.out.println("Вычисление в многопоточном методе заняло " +
                (float) (System.currentTimeMillis() - startTime) / 1000 + " сек.");
    }
}

