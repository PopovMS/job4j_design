package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> map = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileP = new FileProperty(attrs.size(), file.getFileName().toString());
        map.putIfAbsent(fileP, new ArrayList<>(Arrays.asList()));
        map.get(fileP).add(file);
        return super.visitFile(file, attrs);
    }

    public List<List<Path>> getPath() {
        return new ArrayList<>(map.values())
                .stream()
                .filter(vol -> vol.size() > 1)
                .toList();
    }
}