package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);

        if (table[index] != null) {
            return false;
        }
        table[index] = new MapEntry<>(key, value);
        count++;
        modCount++;
        return true;
    }

    @Override
    public V get(K key) {
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        MapEntry<K, V> entry = table[index];

        if (entry != null && Objects.equals(entry.key, key)) {
            return entry.value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        MapEntry<K, V> entry = table[index];

        if (entry != null && Objects.equals(entry.key, key)) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int index = 0; //

            @Override
            public boolean hasNext() {

                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }

                while (index < table.length && table[index] == null) {
                    index++;
                }

                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];

        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int newIndex = indexFor(hash(Objects.hashCode(entry.key)));
                newTable[newIndex] = entry;
            }
        }

        table = newTable;
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
