package ru.job4j.oop;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " 3 путь свободен");
    }
}
