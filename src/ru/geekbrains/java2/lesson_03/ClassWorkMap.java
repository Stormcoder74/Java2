package ru.geekbrains.java2.lesson_03;
// video 2:10
import java.util.ArrayList;
import java.util.HashMap;

public class ClassWorkMap {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("France", "Paris");
        capitalCities.put("Russia", "Moscow");
        capitalCities.put("England", "Lonon");

        System.out.println(capitalCities);
        System.out.println(capitalCities.get("France"));
        System.out.println(capitalCities.get("Russia"));

        System.out.println(capitalCities.getOrDefault("England", "Нету нифига"));
        System.out.println(capitalCities.getOrDefault("Finland", "Нету нифига"));
        System.out.println();

        long time;

        time = System.currentTimeMillis();
        ArrayList<String> strAL = new ArrayList<>(1_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            strAL.add("Entry #" + i);
        }
        System.out.print("Заполнение ArrayList: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        HashMap<String, Integer> strIntHM = new HashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            strIntHM.put("Entry #" + i, i);
        }
        System.out.print("Заполнение HashMap: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            strAL.contains("Entry #522343");
        }
        System.out.print("Поиск в ArrayList: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            strIntHM.containsKey("Entry #522343");
        }
        System.out.print("Поиск в HashMap: ");
        System.out.println(System.currentTimeMillis() - time);
    }
}
