package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        boolean found = false;
        while (index < data.length && !found) {
            if (data[index] % 2 == 0) {
                found = true;
            } else {
                index++;
            }
        }
        return found;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}

