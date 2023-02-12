package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(items[i].getName())) {
                rsl[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(rsl, index);
    }

    public boolean replace(int id, Item item) {
        boolean replace = false;
        int idex = indexOf(id);
        if (idex != -1) {
            item.setId(id);
            items[idex] = item;
            replace = true;
        }
        return replace;
    }

    public boolean delete(int id) {
        boolean delete = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = null;
            int start = id + 1;
            int distPos = id;
            int length = size - id - 1;
            System.arraycopy(items, start, items, distPos, size - index - 1);
            items[size - 1] = null;
            size--;
            delete = true;
        }
        return delete;
    }
}