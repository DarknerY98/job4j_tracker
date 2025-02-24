package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeteleItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram(output)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"7", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditItem(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. New item name" + ln
                        + "1. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 1" + ln
                        + "Menu." + ln
                        + "0. New item name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"1", "0"}
        );
        UserAction[] actions = new UserAction[]{

                new ExitProgram(out),
                new ShowAllItems(out),
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "1. ShowAll Items" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                        + "1. ShowAll Items" + ln
                        + "=== Exit Program ===" + ln

        );
    }

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"1", "78", "0"}
        );
        UserAction[] actions = new UserAction[]{

                new ExitProgram(out),
                new FindItemByName(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "1. Find Item By Name" + ln
                        + "=== Find items by name ===" + ln
                        + "Заявки с именем: 78 не найдены." + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                        + "1. Find Item By Name" + ln
                        + "=== Exit Program ===" + ln

        );
    }

    @Test
    public void whenindItemById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"1", "78", "0"}
        );
        UserAction[] actions = new UserAction[]{

                new ExitProgram(out),
                new FindItemById(out),
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "1. Find Item By Id" + ln
                        + "=== Find item by id ===" + ln
                        + "Заявка с введенным id: 78 не найдена." + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                        + "1. Find Item By Id" + ln
                        + "=== Exit Program ===" + ln

        );
    }

}