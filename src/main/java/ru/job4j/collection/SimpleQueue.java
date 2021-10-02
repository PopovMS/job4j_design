package ru.job4j.collection;

import java.util.NoSuchElementException;

/**
 * Класс описывает организацию данных по алгоритму "FIFO"
 * @param <T> принимает входящий элемент
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * перекладывает элементы из стека in в стек out,
     * извлекает последний элемент из out (бывший первым в in), удаляя его,
     * перекладывает элементы обратно в in
     * @return возвращает извлекаеммый элемент
     */
    public T poll() {
        T rsl;
        while (true) {
            try {
                out.push(in.pop());
            } catch (NoSuchElementException inEx) {
                rsl = out.pop();
                while (true) {
                    try {
                        in.push(out.pop());
                    } catch (NoSuchElementException outEx) {
                        return rsl;
                    }
                }
            }
        }

    }

    /**
     * помещает элемент в стек in
     * @param value принимает элемент коллекции
     */
    public void push(T value) {
        in.push(value);
    }
}