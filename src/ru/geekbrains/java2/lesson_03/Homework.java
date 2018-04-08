package ru.geekbrains.java2.lesson_03;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        task1();
        System.out.println("\n");

        Phonebook phonebook = new Phonebook();
        phonebook.add("Ясенев", "5738665");
        phonebook.add("Сидоров", "2860675");
        phonebook.add("Иванов", "23456");
        phonebook.add("Петров", "87748");
        phonebook.add("Иванов", "9563827");
        phonebook.add("Арбузов", "6749857");

        System.out.println("Иванов: " + phonebook.get("Иванов"));
        System.out.println();
        phonebook.allInfo();
    }

    private static void task1(){
        String[] words = {"Создать", "массив", "набором", "слов",
                "слов", "должны", "массив", "набором", "встречаться",
                "повторяющиеся", "набором", "встречаться",
                "повторяющиеся","Создать", "массив", "набором",
                "должны", "массив", "набором", "уникальный"};
        HashSet<String> stringSet = new HashSet<>(Arrays.asList(words));
        System.out.println(stringSet);

        HashMap<String, Integer> hMap = new HashMap<>();

        for (String s : words)
            hMap.put(s, hMap.getOrDefault(s, 0) + 1);

        Iterator<Map.Entry<String, Integer>> iterM = hMap.entrySet().iterator();
        while (iterM.hasNext()){
            Map.Entry<String, Integer> entry = iterM.next();
            System.out.printf("%s - %d раз\n", entry.getKey(), entry.getValue());
        }
    }
}
