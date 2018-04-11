package ru.geekbrains.java2.lesson_05;

import java.util.Arrays;

public class TwothreadedCalculate {
    public static void calc(float arr[]){
        int half = arr.length / 2;
        float[] arr1 = Arrays.copyOfRange(arr, 0, half);
        float[] arr2 = Arrays.copyOfRange(arr, half, arr.length);
        Thread th1 = new Thread(new ThreadOfCalculation(arr1, 0));
        Thread th2 = new Thread(new ThreadOfCalculation(arr2, half));
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
    }
}
