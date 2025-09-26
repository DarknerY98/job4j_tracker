package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbusA320 = new Airbus("A320");
        System.out.println(airbusA320);
        airbusA320.printAirobusModel();
        airbusA320.printCountEngine();

        final Airbus airbusA380 = new Airbus("A380");
        System.out.println(airbusA380);
        airbusA380.printAirobusModel();
        airbusA380.printCountEngine();

    }
}