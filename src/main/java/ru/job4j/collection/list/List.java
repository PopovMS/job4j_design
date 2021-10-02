package ru.job4j.collection.list;

public interface List<E> extends Iterable<E> {
    int size();
    void add(E value);
    E get(int index);
}