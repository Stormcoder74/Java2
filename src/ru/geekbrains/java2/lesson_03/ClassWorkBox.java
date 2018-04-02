package ru.geekbrains.java2.lesson_03;

import java.util.Arrays;
import java.util.TreeSet;

public class ClassWorkBox implements Comparable {
    private int size;

    public ClassWorkBox(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return ((Integer)this.size).compareTo(((ClassWorkBox)o).size);
    }

    public static void main(String[] args) {
        TreeSet<ClassWorkBox> tSet = new TreeSet<>(Arrays.asList(
                new ClassWorkBox(4),
                new ClassWorkBox(2),
                new ClassWorkBox(8),
                new ClassWorkBox(1)
        ));
        System.out.println(tSet);
    }
}
