package ru.job4j.oop;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;

    LocalDateTime created = LocalDateTime.now();

    public LocalDateTime getcreated() {
       return created;
    }

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}