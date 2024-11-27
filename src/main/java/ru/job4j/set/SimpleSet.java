package ru.job4j.set;

import java.util.Iterator;

public interface SimpleSet<T> extends Iterable<T> {
    boolean add(T value);

    boolean contains(T value);
}
