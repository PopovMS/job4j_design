package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {

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