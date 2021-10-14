package ru.job4j.collection;

import java.util.NoSuchElementException;

/**
 * Класс описывает организацию данных по алгоритму "FIFO"
 * @param <T> принимает входящий элемент
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inCount;
    private int outCount;

    /**
     * перекладывает элементы из стека in в стек out, если последний пустой.
     * возвращает последний элемент из out (первый в очереди)
     * @return возвращает извлекаеммый элемент
     */
    public T poll() {
        if (inCount == 0 && outCount == 0) {
            throw new NoSuchElementException();
        }
        if (outCount == 0) {
            while (inCount > 0) {
                out.push(in.pop());
                inCount--;
                outCount++;
            }
        }
        outCount--;
        return out.pop();
    }

    /**
     * помещает элемент в стек in
     * @param value принимает элемент коллекции
     */
    public void push(T value) {
        in.push(value);
        inCount++;
    }
}