package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getID(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        return storage.replace(id, model) != null;
    }

    @Override
    public void delete(String id) {
    storage.remove(id);
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}
