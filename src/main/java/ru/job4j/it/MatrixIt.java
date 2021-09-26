package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализует итератор для двухмерного массива
 */

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * Метод проверяет наличие следующего элемента в матрице начиная с текущего,
     * устанавливает курсор на найденый элемент, если текущий нулевой.
     * @return возвращает true если элемент найден
     */
    @Override
    public boolean hasNext() {
        while (row < data.length) {
            if (data[row].length != 0) {
                    return true;
            }
            moveCursor();
        }
        return false;
    }

    /**
     * Метод возвращает текущий элемент на который установлен курсор
     * и сдвигает курсор на одно значение вперед
     * @return возвращает текущий элемент матрицы
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[row][column];
        moveCursor();
        return result;
    }

    /**
     * Метод инкрементирует переменные курсора
     */
    public void moveCursor() {
        column++;
        if (column >= data[row].length) {
            row++; column = 0;
        }
    }
}