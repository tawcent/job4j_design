package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    private int inSize;
    private int outSize;

    public T poll() {
        if (inSize == 0 && outSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        for (int i = 0; i < inSize; i++) {
            if (outSize != 0) {
                input.push(output.pop());
            }
            output.push(input.pop());
        }
        outSize = inSize;
        inSize = 0;
        outSize--;
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
        inSize++;
    }
}