package ru.job4j.io;

import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

/**
 * Класс осуществляет архивирование заданного в аргументах каталога и проверяет аргументы
 */

public class Zip {
    /**
     * Метод создает поток и архивирует в него файлы и каталоги из списка
     * @param sources - принимает список типа File
     * @param target - принимает путь для целевого архива
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                System.out.println(source);
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * контролирует количество аргументов
     * @param args принимает массив аргументов
     */
    private void validateCountArgs(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Неверное количество аргументов");
        }
    }

    /**
     * проверяет, что архивируемая папка существует
     * @param start - принимает путь до папки
     */
    private void validateStartDir(Path start) {
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException("Введите имя папки первым аргументом");
        }
    }

    /**
     * проверяет правильность расширения целевого файла с архивом
     * @param target принимает строковое значение, имя файла
     */
    private void validateTargetExt(String target) {
        int dotIndex = target.lastIndexOf('.');
        String ext = (dotIndex == -1) ? "" : target.substring(dotIndex);
        if (!ext.contains(".zip")) {
            throw new IllegalArgumentException("Неверное расширение целевого архива");
        }
    }
    /**
     * проверяет правильность указания расширения
     * @param ext принимает значение расширения
     * @return - возвращает расширение в правильном формате
     */
    private String controlExt(String ext) {
        return (ext.charAt(0) != '.') ? "." + ext : ext;
    }


    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.validateCountArgs(args);
        ArgsName params = ArgsName.of(args);
        Path start = Paths.get(params.get("d"));
        zip.validateStartDir(start);
        String target = params.get("o");
        zip.validateTargetExt(target);
        String finalExt = zip.controlExt(params.get("e"));
        List<File> sources = new ArrayList<>();
        search(start, p -> !p.toFile()
                .getName()
                .endsWith(finalExt))
                .forEach(obj -> sources.add(obj.toFile()));
        zip.packFiles(sources, new File(target));
    }
}