package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Класс реализует поведение простого HashMap
 * @param <K>
 * @param <V>
 */
public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /**
     * Метод добавляет ключ и значение в массив table, вычисляя хэш-код ключа, а затем хеширует.
     * происходит проверка на превышения фактора загрузки, если не превышен, происходит запись в ячейку массива
     * Проверяется, если ячейка массива пуста, происходит создание объекта с ключом и значением и вставка его в
     * массив
     * @param key - принимает объект ключа
     * @param value принимает объект значения
     * @return возвращает true, если вставка осуществилась,
     * возвращает false - если нет.
     */
    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        int hashCode = key.hashCode();
        int hash = hash(hashCode);
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        if (table[indexFor(hash)] == null) {
            MapEntry vol = new MapEntry(key, value);
            table[indexFor(hash)] = vol;
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    /**
     * метод хеширования хэш-значения ключа
     * @param hashCode принимает вычисленное хэш значение
     * @return возвращает хэш
     */
    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode ^ (hashCode >>> 16));
    }

    /**
     * метод вычисляет индекс элемента массива по хэшу
     * @param hash принимает хеш ключа
     * @return возвращает вычисленный индекс
     */
    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    /**
     * Метод увеличивает счетчик capacity в 2 раза, создает новый массив,
     * проходит по всем элементам старого массива и по рехэшированным ключам
     * записывает объекты в новый массив. Переменной table присваивается ссылка на новый массив
     */
    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] temp = new MapEntry[capacity];
        for (MapEntry vol : table) {
            if (vol != null) {
                temp[indexFor(hash(vol.key.hashCode()))] = vol;
            }
        }
        table = temp;
    }

    /**
     * Метод ищет объект в массиве по ключу
     * @param key принимает ключ объекта
     * @return возвращает значение объекта или null если не найден
     */
    @Override
    public V get(K key) {
        V rsl = null;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && table[index].key.equals(key)) {
            rsl = table[index].value;
        }
        return rsl;
    }

    /**
     * Метод удаляет объект из массива
     * @param key принимает ключ по которому ищет объект в массиве
     * @return  возвращает true, если объект найден и удален
     */
    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && table[index].key.equals(key)) {
            table[index] = null;
            count--;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    /**
     * метод возвращает объект итератора
     * @return возвращает объект итератора
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index = 0;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                boolean rsl = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length) {
                    if (table[index] != null) {
                        rsl = true;
                        break;
                    }
                    index++;
                }
                return rsl;
            }
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    /**
     * класс модели данных
     * @param <K>
     * @param <V>
     */
    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
            return Objects.equals(key, mapEntry.key) && Objects.equals(value, mapEntry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

}