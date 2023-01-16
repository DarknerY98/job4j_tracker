package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    private String programLang;

    public Programmer(String programLang, int experienc, boolean degree) {
        super(experienc, degree);
        this.programLang = programLang;
    }
}