package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс реализует поиск значения по файлу со строками
 */
public class LogFilter {
    /**
     * Метод читает файл и фильтрует из него значение переданное с предикатом
     * @param file принимает имя файла
     * @return возвращает отфильтрованный лист
     */
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            rsl = in.lines()
                    .filter(s -> s.contains(" 404 "))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    /**
     * Метод сохраняет отфильтрованный лист в файл
     * @param log принимает лист со строками
     * @param file принимает имя файла, куда нужно записать строки
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String vol : log) {
                out.println(vol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}