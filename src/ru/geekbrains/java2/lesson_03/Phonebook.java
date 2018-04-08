package ru.geekbrains.java2.lesson_03;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook {
    private TreeMap<String, HashSet<String>> directory;

    public Phonebook() {
        directory = new TreeMap<>();
    }

    public void add(String family, String phone){
        if (!directory.containsKey(family)) directory.put(family, new HashSet<>());
            directory.get(family).add(phone);
    }

    public String get(String family){
        return directory.get(family).toString();
    }

    public void allInfo(){
        for (Map.Entry<String, HashSet<String>> entry: directory.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue().toString());
        }
    }
}
