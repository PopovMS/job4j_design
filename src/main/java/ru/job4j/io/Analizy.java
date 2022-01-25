package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringJoiner;

/**
 * Клас считывает файл логов и записывает в другой файл периоды недоступности сервера
 */
public class Analizy {
    public void unavailable(String source, String target) {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String str;
            String[] start = new String[2];
            String[] end = new String[2];
            boolean isDown = false;
            str = read.readLine();
            while (str != null && !str.isEmpty()) {
                if (!isDown && (str.startsWith("500") || str.startsWith("400"))) {
                    isDown = true;
                    start = str.split(" ");
                }
                if (isDown && str.startsWith("200")) {
                    isDown = false;
                    end = str.split(" ");
                    out.add(start[1] + "; " + end[1]);
                }
                str = read.readLine();
            }
            try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(target))) {
                printWriter.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Analizy().unavailable("./server_log.txt", "./unavailable.csv");
    }
}