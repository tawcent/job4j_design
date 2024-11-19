package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            grow();
        }
        container[size++] = value;
        modCount++;
    }

    private void grow() {
        int newCapacity = container.length == 0 ? 1 : container.length * 2;
        container = Arrays.copyOf(container, newCapacity);
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[--size] = null;
        modCount++;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor;
            private int exceptedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkForModifications();
                return cursor < size;
            }

            @Override
            public T next() {
                checkForModifications();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }

            private void checkForModifications() {
                if (modCount != exceptedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
