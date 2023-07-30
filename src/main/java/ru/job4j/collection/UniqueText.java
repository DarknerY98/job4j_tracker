package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        HashSet<String> check_1 = new HashSet<>();
        for (String origins : origin) {
            check.add(origins);
        }
        int a = 0;
        for (String texts : text) {
            if(check.contains(texts)) {
              a++;
            }

        }
        if( a != check.size()) {
            rsl = false;
        }
        return rsl;
    }
}