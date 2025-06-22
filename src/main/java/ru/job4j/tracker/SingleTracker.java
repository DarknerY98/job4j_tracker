package ru.job4j.tracker;
import ru.job4j.tracker.action.Tracker;
import ru.job4j.tracker.action.Item;

import java.util.Arrays;

public class SingleTracker {

    private static SingleTracker instance;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
        System.out.println("Готово");
    }

    public static SingleTracker get() {

        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int itemInt) {
        return tracker.findById(itemInt);
    }

    public Item[] findByName(String nameItem) {
        return tracker.findByName(nameItem);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(int a, Item s) {
        return tracker.replace(a, s);
    }

    public boolean delete(int a) {
        return tracker.delete(a);
    }

}
