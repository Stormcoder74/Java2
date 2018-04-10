package ru.geekbrains.java2.lesson_05.Classwork;

public class MainClass {
    public static void main(String[] args) {
        /*System.out.println(Thread.currentThread().getName());

        MyThread myT1 = new MyThread();
        MyThread myT2 = new MyThread();
        myT1.start();
        myT2.start();

        Thread myR3 = new Thread(new MyRunnable());
        Thread myR4 = new Thread(new MyRunnable());
        myR3.start();
        myR4.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");*/

       /* Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 6; i++) {
                    System.out.println(i);
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 11; i < 16; i++) {
                    System.out.println(i);
                }
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");*/

      /* Thread th = new Thread(new Runnable() {
           @Override
           public void run() {
               int time = 0;
               while (true){
                   time++;
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(time);
               }
           }
       });
       th.setDaemon(true);
       th.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");*/

        Counter counter = new Counter();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.inc();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.dec();
                }
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.value());
    }
}
