package ru.geekbrains.java2.lesson_03.Classwork;

import java.util.*;

public class ClassWorkIterator {
    public static void main(String[] args) {
        // ошибочная реализация
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 1, 0, 4, 6, 2, 2, 6));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) list.remove(i);
        }
        System.out.println(list);

        // верная реализация
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 1, 0, 4, 6, 2, 2, 6));
        Iterator<Integer> iter = list2.iterator();
        while (iter.hasNext()){
            if(iter.next() == 2) {
                iter.remove();
            }
        }
        System.out.println(list2);

        // реализация на HashMap
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("a", 1);
        hm.put("b", 5);
        hm.put("c", 3);
        hm.put("d", 8);
        hm.put("e", 6);
        hm.put("f", 0);
        Iterator<Map.Entry<String, Integer>> iter2 = hm.entrySet().iterator();
        while (iter2.hasNext()){
            Map.Entry<String, Integer> entry = iter2.next();
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

    }
    
}
