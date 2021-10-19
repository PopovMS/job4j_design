package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;

/**
 * Класс реализует простую коллекцию
 * @param <T> принимает обобщенный тип
 */

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(5);

    @Override
    public boolean add(T value) {
        for (T vol : set) {
            if (vol == value || vol.equals(value)) {
                return false;
            }
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        for (T vol : set) {
            if (vol == value || vol.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}