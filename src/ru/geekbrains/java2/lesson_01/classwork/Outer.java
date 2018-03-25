package ru.geekbrains.java2.lesson_01.classwork;

public class Outer {

    public class Inner{
        private int innerVar;

        public Inner(int innerVar) {
            this.innerVar = innerVar;
        }

        public void info(){
            System.out.println(innerVar + "/" + outVar);
        }
    }

    private int outVar;

    public Outer(int outVar) {
        this.outVar = outVar;
    }

    public void info(){
        Inner inner = new Inner(1);
        System.out.println(outVar + "/" + inner.innerVar);
    }
}
