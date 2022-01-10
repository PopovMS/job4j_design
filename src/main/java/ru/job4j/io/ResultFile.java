package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * Метод записывает матрицу таблицы умножения в файл
 */
public class ResultFile {
    public static void main(String[] args) {
        ResultFile rsl = new ResultFile();
        int[][] matrix = rsl.multiple(9);
        String string;
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] row : matrix) {
                string = Arrays.toString(row);
                out.write(string.getBytes());
                out.write(System.lineSeparator().getBytes());
                string = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создает матрицу таблицы умножения со стороной размером size
     * @param size принимает размер стороны матрицы
     * @return возвращает двумерный массив
     */
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 0; row < table.length; row++) {
            for (int cell = 0; cell < table[row].length; cell++) {
                table[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return table;
    }
}