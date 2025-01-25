package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        Path dir = Paths.get(cachingDir);
        if (!Files.isDirectory(dir)) {
            throw new IllegalArgumentException(String.format("Папки с именем %s не существует", cachingDir));
        }
        if (!cachingDir.endsWith("\\")) {
            cachingDir = cachingDir.concat("\\");
        }
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {

        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(
                new FileReader(cachingDir
                        .concat(key)))) {
            reader.lines()
                    .forEach(joiner::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return joiner.toString();
    }
}