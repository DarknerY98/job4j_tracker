package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

        public static void main(String[] args) {
            HashMap<String, String> map = new HashMap<>();
            map.put("parsentev@yandex.ru", "Petr Arsentev");
            map.put("parsentev89@yandex.ru", "Petr Arsentev Sergeevich");
            map.put("petrkulikov@yandex.ru", "Petr Kulikov");
            map.put("ingaivanova@yandex.ru", "Inga Ivanova");
            map.put("ingaivanova@yandex.ru", "Inga Ivanova");
            for (String key : map.keySet()) {
                String value = map.get(key);
                System.out.println(key + " = " + value);
            }
        }
    }
