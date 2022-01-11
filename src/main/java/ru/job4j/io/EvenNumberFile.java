package ru.job4j.io;

import java.io.FileInputStream;

/**
 * Класс читает значения из файла и выводит в консоль только четные числа
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] array = text.toString().split("\r\n");
            for (String vol : array) {
                if (Integer.parseInt(vol) % 2 == 0) {
                    System.out.println(vol);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
