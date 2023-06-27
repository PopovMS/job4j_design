package ru.job4j.io.duplicates;

import ru.job4j.io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        search().forEach(System.out::println);
    }

    public static List<List<Path>> search() throws IOException {
        DuplicatesVisitor searcher = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("c:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\io\\duplicates"), searcher);
        return searcher.getPath();
    }
}