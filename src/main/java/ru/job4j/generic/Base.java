package ru.job4j.generic;

public abstract class Base {
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
}
