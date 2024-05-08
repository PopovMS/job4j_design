package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        String out = argsName.get("out");
        Path targetPath;
        if (out.equals("stdout")) {
            targetPath = Paths.get("C:\\Projects\\job4j_design\\data\\target.csv");
        } else {
            targetPath = Paths.get(out);
        }
        List<String> target = new ArrayList<>();

        var line = new Scanner(new ByteArrayInputStream(readFile(argsName.get("path")).getBytes()))
        .useDelimiter(System.getProperty("line.separator"));

        /* Извлекаем строку с названием столбцов */
            if (line.hasNext()) {
              List<String> header = new ArrayList<>(Arrays.asList(line.nextLine().split(argsName.get("delimiter"))));

                /* Извлекаем список фильтров в массив*/
              String[] filter = argsName.get("filter").split(",");

                /* Создание массива индексов искомых столбцов*/
              int[] indexColumn = new int[filter.length];
              for (int i = 0; i < filter.length; i++) {
                  indexColumn[i] = header.indexOf(filter[i]);
              }
              target.add(filterLine(header, indexColumn, argsName.get("delimiter")));

                /* Чтение из файла остальных строк таблицы и запись их в массив target*/
              while (line.hasNext()) {
                  List<String> nextLine = new ArrayList<>(Arrays.asList(line.nextLine().split(argsName.get("delimiter"))));
                  target.add(filterLine(nextLine, indexColumn, argsName.get("delimiter")));
              }
            }

        saveFile(target, targetPath.toString());
    }

    /**
     * Метод читает сроки из файла
     * @param path принимает путь к файлу
     * @return возвращает строку разделенную пробелами
     */
    private static String readFile(String path) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines()
                    .forEach(joiner::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return joiner.toString();
    }
    /**
     * Метод записывает Arraylist в файл
     * @param target принимает список строк
     * @param path принимает путь до целевого файла
     */
    private static void saveFile(List<String> target, String path) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            target.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Метод принимает строку и фильтрует из нее нужные столбцы
     * @param line Исходная строка
     * @param index порядковый номер искомых столбцов
     * @param delimiter разделитель используемый в исходном файле
     * @return возвращает отфильтрованную строку
     */
    private static String filterLine(List<String> line, int[] index, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (int vol : index) {
            joiner.add(line.get(vol));
        }
        return joiner.toString();
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);

        /* Проверка правильности ключей */
        List.of("path", "delimiter", "out")
                .forEach(argsName::get);

        /* Проверка значения аргумента out */
        String out = argsName.get("out");
        if (!out.equals("stdout")) {
            if (!Paths.get(out).isAbsolute()) {
                throw new IllegalArgumentException("Неверный формат аргумента out");
            }
        }
        handle(argsName);
    }
}