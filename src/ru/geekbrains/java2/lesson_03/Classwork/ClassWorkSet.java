package ru.geekbrains.java2.lesson_03.Classwork;

import java.util.HashSet;
import java.util.TreeSet;

public class ClassWorkSet {
    public static void main(String[] args) {
        HashSet<String> hSet = new HashSet<>();
        hSet.add("K");
        hSet.add("tSet");
        hSet.add("C");
        hSet.add("E");
        hSet.add("C");
        hSet.add("static");
        hSet.add("add");
        hSet.add("A");
        hSet.add("tSet");
        hSet.add("main");
        hSet.add("main");
        hSet.add("addddddd");
        System.out.println(hSet);

        TreeSet<String> tSet = new TreeSet<>();
        tSet.add("K");
        tSet.add("tSet");
        tSet.add("C");
        tSet.add("E");
        tSet.add("C");
        tSet.add("static");
        tSet.add("add");
        tSet.add("A");
        tSet.add("tSet");
        tSet.add("main");
        tSet.add("main");
        tSet.add("addddddd");
        System.out.println(tSet);

    }
}
