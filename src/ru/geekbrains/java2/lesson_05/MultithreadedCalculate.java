package ru.geekbrains.java2.lesson_05;

import java.util.ArrayList;
import java.util.Arrays;

public class MultithreadedCalculate {
    public static void calc(float arr[]) {
        int partSize = 100000; // РЕГУЛИРОВАТЬ КОЛ-ВО ПОТОКОВ МОЖНО ЭТОЙ ВЕЛИЧИНОЙ
        ArrayList<float[]> arrayList = new ArrayList<>();

        int currentLocatin = 0;
        int nextLocation = partSize;

        while (currentLocatin < arr.length) {
            if (nextLocation < arr.length)
                arrayList.add(Arrays.copyOfRange(arr, currentLocatin, nextLocation));
            else
                arrayList.add(Arrays.copyOfRange(arr, currentLocatin, arr.length));
            currentLocatin = nextLocation;
            nextLocation += partSize;
        }

        ArrayList<Thread> threadList = new ArrayList<>();
        for (float[] a : arrayList) {
            Thread tmp = new Thread(new ThreadOfCalculation(a));
            threadList.add(tmp);
            tmp.start();
        }

        for (Thread h : threadList) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        currentLocatin = 0;
        for (float[] a : arrayList) {
            System.arraycopy(a, 0, arr, currentLocatin, a.length);
            //  раскоментить цикл ниже для вывода границ склейки массивов
            /*for (int i = currentLocatin; i < currentLocatin + partSize; i++) {
                System.out.println("arr[" + i + "]: " + arr[i]);
                if (i > currentLocatin + 2 && i < currentLocatin + partSize - 3) i = currentLocatin + partSize - 3;
            }*/
            currentLocatin += partSize;
        }
    }
}
