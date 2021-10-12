package ru.job4j.collection;

/**
 * Класс описывает организацию данных по алгоритму "FIFO"
 * @param <T> принимает входящий элемент
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int count;
    /**
     * перекладывает элементы из стека in в стек out,
     * извлекает последний элемент из out (бывший первым в in), удаляя его,
     * перекладывает элементы обратно в in
     * @return возвращает извлекаеммый элемент
     */
    public T poll() {
        T rsl;
        int tempCount = count;
        while (tempCount > 0) {
                out.push(in.pop());
                tempCount--;
        }
        rsl = out.pop();
        count--;
        while (tempCount < count) {
            in.push(out.pop());
            tempCount++;
        }
        return rsl;
    }

    /**
     * помещает элемент в стек in
     * @param value принимает элемент коллекции
     */
    public void push(T value) {
        in.push(value);
        count++;
    }
}