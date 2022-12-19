package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String endtorus = "Неизвестное слово. " + eng;
        return endtorus;

    }

    public static void main(String[] args) {
        DummyDic a = new DummyDic();
        System.out.println(a.engToRus("abcd"));
    }

}
