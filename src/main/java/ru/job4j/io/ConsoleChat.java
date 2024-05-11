package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    /**
     * Метод с логикой
     */
    public void run() {
        List<String> answers = readPhrases(botAnswers);
        int countLines = answers.toArray().length;
        List<String> log = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String input;
        boolean pause = false;
        do {
            input = in.nextLine();
            log.add(input);
            if (STOP.contains(input)) {
                pause = true;
            }
            if (CONTINUE.contains(input)) {
                pause = false;
            }
            if (!pause && !OUT.contains(input)) {
                int random = (int) (Math.random() * countLines);
                System.out.println(answers.get(random));
                log.add(answers.get(random));
            }
        }
        while (!OUT.contains(input));
        saveLog(log);
    }

    /**
     * Метод читает файл и записывает его садержимое в список
     * @param path принимает путь до файла
     * @return возвращает список строк из прочитанного файла
     */
    private List<String> readPhrases(String path) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines()
                    .map(string -> string + System.lineSeparator())
                    .forEach(result::add);
        } catch (IOException e) {
            LOG.error("ERROR", e);
        }
        return result;
    }

    /**
     * Метод читает список строк и записывает их в файл
     * @param log принимает список строк
     */
    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            LOG.error("ERROR", e);
        }

    }

    public static void main(String[] args) {

        ConsoleChat consoleChat = new ConsoleChat("C:\\Projects\\job4j_design\\data\\log.txt", "C:\\Projects\\job4j_design\\data\\AnswersOfBot.txt");
        consoleChat.run();
    }
}