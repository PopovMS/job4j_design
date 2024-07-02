package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Клас переопределяет интерфейс итератор
 *
 */
public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    /**
     * Конструктор класса
     * @param data принимает массив Integer записывает его в локальную переменную data
     */
    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    /**
     * Метод ищет ближайшее не null значение в массиве
     * @return возвращает true если не null значение найдено
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index < data.length) {
            if (!Objects.isNull(data[index])) {
                result = true;
                break;
            }
            index++;
        }
        return result;
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