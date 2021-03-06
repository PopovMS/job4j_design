package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс описывает односвязный контейнер данных
 * @param <T> принимает элемент контейнера
 */
public class ForwardLinked<T> implements Iterable<T> {
    /**
     * Ссылка на первый елемент хранилища
     */
    private Node<T> head;

    /**
     * Метод ищет последний элемент коллекции и добавляет следующим переданный элемент
     * @param value принимает элемент коллекции
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Метод добавляет элемент в начало коллекции,
     * меняет ссылку поля класа head на этот элемент
     * @param value принимает элемент коллекции
     */
    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }

    /**
     * Метод удаляет первый элемент из коллекции
     * @return возвращает значение удаленного элемента коллекции
     */

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T rsl = head.value;
        Node<T> delNode = head;
        head = head.next;
        delNode.next = null;
        return rsl;
    }

    /**
     * метод переворачивает ссылки на элементы связанного списка
     * @return
     */
    public boolean revert() {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> prevNode = null;
        Node<T> actNode = head;
        while (actNode != null) {
            Node<T> nextNode = actNode.next;
            actNode.next = prevNode;
            prevNode = actNode;
            actNode = nextNode;
        }
        head = prevNode;
        return true;
    }

    /**
     * Итератор класса
     * @return возвращает текущий элемент
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    /**
     * Вложенный класс описывает модель данных узла Node
     * @param <T> принимает объект коллекции
     */
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}