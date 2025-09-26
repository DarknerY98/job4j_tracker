package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private String name;
    private static final int COUNT_ENGINE = 2;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printAirobusModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        int countEngine = getCountEngine();
        System.out.println("Количество двигателей равно: " + countEngine);
    }

    private int getCountEngine() {
        // A380 имеет 4 двигателя, остальные модели - 2
        if ("A380".equals(name)) {
            return 4;
        }
        return COUNT_ENGINE;
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}