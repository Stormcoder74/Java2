package ru.geekbrains.java2.lesson_03;

import java.util.Map;
import java.util.TreeMap;

public class Phonebook {
    private TreeMap<String, String> directory;

    public Phonebook() {
        directory = new TreeMap<>();
    }

    public void add(String family, String phone){
        if (directory.containsKey(family)){
            directory.replace(family, directory.get(family) + ", " + phone);
        }else
            directory.put(family, phone);
    }

    public String get(String family){
        return directory.get(family);
    }

    public void allInfo(){
        for (Map.Entry<String, String> entry: directory.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}
