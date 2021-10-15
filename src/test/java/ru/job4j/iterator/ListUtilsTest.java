package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 3, 2)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveWithPredicate() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ListUtils.removeIf(input, x -> x < 3);
        assertThat(input, is(Arrays.asList(3, 4)));
    }

    @Test
    public void whenReplaceWithPredicate() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ListUtils.replaceIf(input, x -> x < 3, 5);
        assertThat(input, is(Arrays.asList(5, 5, 5, 3, 4)));
    }

    @Test
    public void whenRemoveWithList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> delList = new ArrayList<>(Arrays.asList(2, 3));
        ListUtils.removeAll(input, delList);
        assertThat(input, is(Arrays.asList(0, 1, 4)));
    }
}