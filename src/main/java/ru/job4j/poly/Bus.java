package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.print("Поехали");

    }

    @Override
    public void passengers(int passengers) {
        System.out.print(passengers);
    }

    @Override
    public double refuel(double fuel) {
        double price = fuel * 47.53;
        return price;
    }
}
