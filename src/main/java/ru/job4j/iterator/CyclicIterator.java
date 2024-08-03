package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data;
    private int index;

    /**
     * Конструктор класса
     * @param data принимает Список объектов
     */
    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    /**
     * Метод проверяет, не пустой ли список
     * @return возвращает true если список содержит объекты
     */
    @Override
    public boolean hasNext() {
        return !data.isEmpty();
    }

    /**
     * Метод возвращает текущее значение и сдвигает курсор дальше
     * @return возвращает текущее значение
     */
    @Override
    public T next() {
        if (index == data.size()) {
            index = 0;
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(index++);
    }
}