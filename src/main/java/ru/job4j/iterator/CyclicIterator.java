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
     * Метод ищет ближайший не null объект
     * @return возвращает true если не null значение найдено
     */
    @Override
    public boolean hasNext() {
        if (index == data.toArray().length) {
            index = 0;
        }
        while (index < data.toArray().length) {
            if (!Objects.isNull(data.get(index))) {
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Метод возвращает текущее значение и сдвигает курсор дальше
     * @return возвращает текущее значение
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(index++);
    }
}