package ru.job4j.collection;

/**
 * Метод описывает работу стека
 * @param <T> принимает элемент стека
 */

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    /**
     * Метод возвращает элемент стека, добавленный последним и удаляет его
     * @return возвращает элемент стека
     */
    public T pop() {
        return linked.deleteFirst();
    }

    /**
     * Метод помещает элемент в стек в его начало
     * @param value принимает размещаемый элемент стека
     */
    public void push(T value) {
        linked.addFirst(value);
    }
}
