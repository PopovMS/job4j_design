package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

/**
 * Класс демонстрирует использование ListIterator
 */

public class ListUtils {
    /**
     * Метод вставляет объект до индекса
     * @param list принимает входящий список в который добавляется элемент
     * @param index индекс, перед которым нужно вставить объект
     * @param value добавляемый объект
     * @param <T> принимает обобщенный тип
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index);
        i.add(value);
    }

    /**
     * Метод вставляет объект после индекса
     * @param list принимает входящий список в который добавляется элемент
     * @param index индекс, после которого нужно вставить объект
     * @param value добавляемый объек
     * @param <T> принимает обобщенный тип
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index + 1);
        i.add(value);
    }

    /**
     * Метод удаляет все элементы, которые удовлетворяют предикату.
     * @param list принимает входящий список из которого удалается элемент
     * @param filter предикат, при выполнении условия которого, удаляется текущий объект
     * @param <T> принимает обобщенный тип
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
    }

    /**
     * Метод заменяет все элементы, которые удовлетворяют предикату;
     * @param list принимает входящий список в котором замещаются элементы
     * @param filter принимает предикат, при выполнении условия которого, замещаются элементы  всписке
     * @param value принимает элемент, на который меняется значение, когда предикат true
     * @param <T> принимает обобщенный тип
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
    }

    /**
     * Метод удаляет из списка те элементы, которые есть в elements
     * @param list принимает входящий список в котором удаляются элементы
     * @param elements список удаляемых элементов
     * @param <T>  принимает обобщенный тип
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (elements.contains(i.next())) {
                i.remove();
            }
        }
    }

}
