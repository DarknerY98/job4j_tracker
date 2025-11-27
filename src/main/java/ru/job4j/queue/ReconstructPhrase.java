package ru.job4j.queue;

import java.util.Arrays;
import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder elements = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                elements.append((Character) evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return elements.toString();
    }

    private String getDescendingElements() {
        StringBuilder elements = new StringBuilder();
        while ((!descendingElements.isEmpty())) {
            elements.append((Character) descendingElements.pollFirst());
        }
        return elements.reverse().toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}