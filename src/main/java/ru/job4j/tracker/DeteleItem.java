package ru.job4j.tracker;

public class DeteleItem implements UserAction {

    private final Output out;

    public DeteleItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Detele Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
