package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

/**
 * Реализация списка на основе динамического массива, аналог ArrayList
 * @param <T> Принимает любой тип
 */

public class SimpleArrayList<T> implements List<T> {
    /**
     * Поля класса содержат массив, size - размер коллекции, modCount - число изменений размера коллекции
     */
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    /**
     * Добавляет элемент в коллекцию. Проверяет, если массив закончился,
     * то переписывает коллекцию  в новый удвоенный в размере массив
     * @param value - добавляемый элемент
     */
    @Override
    public void add(T value) {
        modCount++;
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size] = value;
        size++;
    }

    /**
     * Проверяет индекс, находится ли в рамках размера массива.
     * Копирует старое значение в переменную, переписывает ячейку новым значением,
     * возвращает старое значение
     * @param index - принимает индекс ячейки
     * @param newValue - принимает новое значение ячейки
     * @return возвращает замененное значение
     */
    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, container.length);
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    /**
     * Копирует удаляемое содержимое, удаляет значение по индексу
     * и сдвигает часть массива после удаляемого элемента влево,
     * в освободившуюся последнюю ячейку записывает null
     * @param index - принимает индекс удаляемого значения
     * @return возвращает удаленное значение
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, container.length);
        modCount++;
        T removeValue = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        size--;
        return removeValue;
    }

    /**
     * Возвращает содержимое ячейки по индексу
     * @param index принимает индекс по которому нужно вернуть элемент
     * @return возвращает элемент коллекции по индексу
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    /**
     * Класс возвращает размер коллекции
     * @return возвращает размер коллекции
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Итератор класса
     * @return возвращает элемент коллекции
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[cursor++];
            }

        };
    }
}
