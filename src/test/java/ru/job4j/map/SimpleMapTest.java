package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.collection.SimpleArrayList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Клас для тестирования класса SimpleMap
 */
public class SimpleMapTest {

    @Test
    public void whenPutNewThenTrue() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertThat(map.put(123, "Ivan"), is(true));
    }

    @Test
    public void whenPutDuplicateThenFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(123, "Ivan");
        assertThat(map.put(123, "Ivan"), is(false));
    }

    @Test
    public void whenRemoveThenTrue() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(123, "Ivan");
        assertThat(map.remove(123), is(true));
    }

    @Test
    public void whenRemoveEmptyThenFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertThat(map.remove(123), is(false));
    }

    @Test
    public void whenGetIteratorHasNextFromEmptyMapThenReturnFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertThat(map.iterator().hasNext(), is(false));
    }

    SimpleMap<Integer, String> map = new SimpleMap<>();
    @Before
    public void initData() {
        map.put(123, "Ivan");
        map.put(330, "Petr");
        map.put(624, "Roman");
    }

    @Test
    public void whenSetByIncorrectKeyThenReturnNull() {
        assertNull(map.get(100));
    }

    @Test
    public void whenSetKeyThenReturnValue() {
        assertThat(map.get(330), is("Petr"));
        assertThat(map.get(123), is("Ivan"));
        assertThat(map.get(624), is("Roman"));
    }

    @Test
    public void whenCheckIterator() {
        Iterator<Integer> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(624));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(330));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(123));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyMapThenNextThrowException() {
        SimpleMap<Integer, String> map2 = new SimpleMap<>();
        Iterator<Integer> iterator = map2.iterator();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenPutAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = map.iterator();
        map.put(777, "Vasya");
        iterator.next();
    }
}
