package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Клас переопределяет интерфейс итератор
 *
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    /**
     * Поля массива и индекса
     */
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    /**
     * Метод ищет ближайшее четное значение в массиве
     * @return возвращает true если четное значение найдено
     */
    @Override
    public boolean hasNext() {
        while (index < data.length) {
            if (data[index] % 2 == 0) {
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Метод возвращает текущее значение и сдвигает курсор дальше
     * @return возвращает текущее значение массива
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}