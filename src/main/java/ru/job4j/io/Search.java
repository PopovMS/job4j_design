package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 *Клас осуществляет обход дерева файлов и каталогов и ищет файлы по условию в предикате
 */
public class Search {
    /**
     *Метод запуска
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        testParam(args);
        Path start = Paths.get(args[0]);
        String ext = args[1];
        search(start, p -> p.toFile().getName().endsWith(ext)).forEach(System.out::println);
    }

    /**
     *Метод принимает путь к файлу и предикат
     * @param root - Путь начала поиска
     * @param condition предикат - условие поиска
     * @return Возвращает результат поиска ввиде списка
     * @throws IOException
     */
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * Метот проверяет количество переданных параметров и их соответствия требованиям
     * @param args - принимает массив с параметрами
     * @return - возвращает true, если параметры соответствуют требованиям
     */
    private static boolean testParam(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Отсутствуют параметры. Используйте 2 параметра.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        return true;
    }
}