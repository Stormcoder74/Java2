package ru.geekbrains.java2.lesson_03.Classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassWorkArrList {
    public static void main(String[] args) {
        List<String> list = new  ArrayList<>(Arrays.asList("A", "@", "Core", "Java", "Home"));

        list.add("Hello");
        list.remove("@");
        list.remove(2);

        System.out.println(list);

        list.set(2, "Фффигасе");

        System.out.println(list.get(2));
        System.out.println();

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(4);
        intList.add(3);
        intList.add(2);
        intList.add(1);
        intList.add(0);
        System.out.println(intList);

        intList.add(3, 10);
        System.out.println(intList);

        intList.remove(4);
        System.out.println(intList);

        intList.remove((Integer) 4);
        System.out.println(intList);
        System.out.println();

        ArrayList<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("C");
        strList.add("A");
        strList.add("A");
        strList.add("B");
        strList.add("D");
        do {
            System.out.println(strList);
        }while (strList.remove("A"));

//        strList.clear();
//        System.out.println(strList);


        ArrayList<String> strList2 = new ArrayList<>();
        strList2.add("N");
        strList2.add("K");
        strList2.add("S");

        strList.addAll(strList2);
        strList.add(1, "S");
        System.out.println(strList);
        strList.removeAll(strList2);
        System.out.println(strList);
    }
}
