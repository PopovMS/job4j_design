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
     * Если по хешу метод get возвращает null, значит ячейка массива свободна, происходит проверка
     * на превышения фактора загрузки, если не превышен, происходит запись в ячейку массива
     * @param key - принимает объект ключа
     * @param value принимает объект значения
     * @return возвращает true, если вставка осуществилась,
     * возвращает false - если нет.
     */
    @Override
    public boolean put(K key, V value) {
        int hashCode = key.hashCode();
        int hash = hash(hashCode);
        if (get(key) == null) {
            if ((float) count / (float) capacity >= LOAD_FACTOR) {
                expand();
            }
            MapEntry vol = new MapEntry(key, value);
            table[indexFor(hash)] = vol;
            count++;
            modCount++;
            return true;
        }
        return false;
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
            temp[indexFor(hash(vol.hashCode()))] = vol;
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
        for (MapEntry vol : table) {
            if (vol != null && key.equals(vol.key)) {
                return (V) vol.value;
            }
        }
        return null;
    }

    /**
     * Метод удаляет объект из массива
     * @param key принимает ключ по которому ищет объект в массиве
     * @return  возвращает true, если объект найден и удален
     */
    @Override
    public boolean remove(K key) {
        for (MapEntry vol : table) {
            if (vol != null && key.equals(vol.key)) {
                table[indexFor(hash(key.hashCode()))] = null;
                count--;
                modCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * метод возвращает объект итератора
     * @return возвращает объект итератора
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int cursor = 0, index = 0;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return cursor < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                cursor++;
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