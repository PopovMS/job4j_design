package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Клас записывает в мапу содержимое файла конфигурации и выдает значение по ключу
 */
public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    /**
     * Конструктор класса принимает переменную содержащую путь до файла
     * @param path путь до файла конфигурации
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод записывает содержимое файла конфигурации в HashMap,
     * игнорирует пустые строки и закомментированные символом "#",
     * выбрасывает исключение IllegalArgumentException если ключ значения отсутствует.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .map(s -> s.split("="))
                    .filter(array -> array.length > 1)
                    .filter(vol -> !vol[0].startsWith("#"))
                    .forEach(vol -> {
                        if (vol[0].isEmpty()) {
                            throw new IllegalArgumentException();
                        }
                        values.put(vol[0], vol[1]);
                    }
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает значение по ключу
     * @param key принимает значение
     * @return возвращает из HashMap значение
     */
    public String value(String key) {
        return values.get(key);
    }

    /**
     * Переопределенный метод toString
     * @return возвращает содержимое файла конфигурации в консоль.
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        new Config("app.properties").load();
        System.out.println(new Config("app.properties"));
    }
}
