package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int size = this.tasks.size();
        int index = 0;
        if (size == 0) {
            this.tasks.add(index, task);
        }
        if (size != 0) {
            for (Task element : tasks) {
                if (task.getPriority() < element.getPriority()) {
                    this.tasks.add(index, task);
                    break;
                }
                if (task.getPriority() >= element.getPriority()) {
                    index += 1;
                }
            }
            this.tasks.add(index, task);
        }
    }

    public Task take() {
        return tasks.poll();
    }

}