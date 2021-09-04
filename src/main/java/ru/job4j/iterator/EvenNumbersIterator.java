package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Клас переопределяет интерфейс итератор
 * Содержит поля массива и указателя
 */
public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return search(index, false) != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return search(index, true);
    }

    /**
     * общий метод перебора массива и поиска четного значения
     * @param index принимает значение указателя - с какого элемента массива вести поиск
     * @param vol булево значение, при значении true после удачного поиска
     *            переводит указатель на значение следующее за искомым.
     * @return возвращает найденый элемент массива. Если не найдено то null
     */
    public Integer search(int index, boolean vol) {
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                if (vol) {
                    this.index = i + 1;
                }
                return data[i];
            }
        }
        return null;
    }

}