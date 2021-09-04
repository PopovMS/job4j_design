package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return search(false) != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return search(true);
    }
    public Integer search(boolean vol) {
        for (int r = row; r < data.length; r++) {
            for (int c = column; c < data[r].length; c++) {
                if (data[r][c] != 0) {
                    if (vol) {
                        column++;
                        if (column >= data[row].length) {
                            row++; column = 0;
                        }
                    }
                    return data[r][c];
                }
            }
        }
        return null;
    }
}