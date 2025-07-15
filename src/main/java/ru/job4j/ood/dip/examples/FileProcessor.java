package ru.job4j.ood.dip.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessor {
    private FileReader fileReader;

    public FileProcessor() {
        this.fileReader = new FileReader(); /* Жесткая зависимость */
    }

    public String readFile(String path) throws IOException {
        return fileReader.read(path);
    }
}

class FileReader {
    public String read(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}

/*
Причина нарушения:
1. FileProcessor напрямую зависит от конкретной реализации FileReader
2. Невозможно подменить реализацию чтения файлов
3. Сложности с тестированием
*/