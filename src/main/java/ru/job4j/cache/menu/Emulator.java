package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Emulator {

    private static DirFileCache cache;
    private static String dir;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            int choice = 0;
            System.out.println("1. Указать кэшируемую директорию");
            System.out.println("2. Загрузить содержимое файла в кэш");
            System.out.println("3. Получить содержимое файла из кэша");
            System.out.println("4. Выход");
            System.out.print("Выберите опцию: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Введите путь к кэшируемой директории: ");
                    dir = scanner.nextLine();
                    if (!checkDir(dir)) {
                        System.out.printf("Папки с именем %s не существует. Введите корректное имя папки.%n", dir);
                        break;
                    }
                    cache = new DirFileCache(dir);
                    break;
                case 2:
                    System.out.print("Введите имя файла для загрузки в кэш: ");
                    String fileToLoad = scanner.nextLine();
                    if (!fileExist(fileToLoad)) {
                        System.out.printf("Файла с именем %s не существует. Введите корректное имя файла.%n", fileToLoad);
                        break;
                    }
                    if (cache != null) {
                        cache.get(fileToLoad);
                        System.out.println("Файл загружен в кэш.");
                    } else {
                        System.out.println("Сначала укажите кэшируемую директорию.");
                    }
                    break;
                case 3:
                    System.out.print("Введите имя файла для получения из кэша: ");
                    String fileToGet = scanner.nextLine();
                    if (!fileExist(fileToGet)) {
                        System.out.printf("Файла с именем %s не существует. Введите корректное имя файла.%n", fileToGet);
                        break;
                    }
                    if (cache != null) {
                        String content = cache.get(fileToGet);

                        System.out.println("Содержимое файла: " + content);
                    } else {
                        System.out.println("Сначала укажите кэшируемую директорию.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static boolean checkDir(String path) {
        if (!path.endsWith("\\")) {
            dir = path.concat("\\");
        }
        Path directory = Paths.get(path);
        return Files.isDirectory(directory);
    }

    private static boolean fileExist(String fileName) {
        Path path = Paths.get(dir.concat(fileName));
        return Files.exists(path);
    }
}