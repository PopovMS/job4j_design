package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Класс описывает простой связный список,
 * реализует интерфейс List
 * @param <E> принимает объект обобщенного типа
 */

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    /**
     * Вложенный класс описывает модель данных узла Node
     * @param <E> принимает объект обобщенного типа
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.item = element;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * добавляет элемент в конец списка, изменяет состояние полей родительского класса
     * @param value принимает элемент для добавления в коллекцию
     */
    @Override
    public void add(E value) {
        Node<E> node = new Node<E>(value);
        if (size == 0) {
            first = node;
        } else {
            node.prev = last;
            last.next = node;
        }
        last = node;
        size++;
        modCount++;
    }

    /**
     * Получает элемент по индексу, проверяет индекс на валидность
     * @param index индекс искомого элемента коллекции
     * @return возвращает элемент из коллекции
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = first;
        if (index != 0) {
            for (int i = 1; i < size; i++) {
                rsl = rsl.next;
            }
        }
        return rsl.item;
    }

    /**
     * Итератор класса
     * @return возвращает элемент коллекции
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;
            int expectedModCount = modCount;
            Node<E> rsl = first;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (cursor != 0) {
                    rsl = rsl.next;
                }
                cursor++;
                return rsl.item;
            }

        };
    }
}