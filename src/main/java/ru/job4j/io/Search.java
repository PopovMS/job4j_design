package ru.job4j.io;

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
        Path start = Paths.get(".");
        search(start, p -> p.toFile().getName().endsWith(".js")).forEach(System.out::println);
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
}