package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties config;
    private String dump;

    public ImportDB(Properties config, String dump) {
        this.config = config;
        this.dump = dump;
    }

    /**
     * загружает данные из файла в формате ключ-значение, проверяет ключевую пару на валидность
     * @return возвращает ArrayList объектов User
     * @throws IOException - возможны исключения при попытке чтения из файла
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            reader.lines()
                    .filter(s -> !s.startsWith("#"))
                    .filter(s -> !s.isEmpty())
                    .map(s -> s.split(";"))
                    .filter(array -> !array[0].isEmpty())
                    .forEach(vol -> {
                                if (vol.length != 2) {
                                    throw new IllegalArgumentException();
                                }
                                users.add(new User(vol[0], vol[1]));
                            }
                    );
        }
        return users;
    }

    /**
     * Сохранает объекты User из ArrayList в базу данных
     * @param users принимает список объектов
     * @throws ClassNotFoundException - возможно отсутствие класса
     * @throws SQLException - возможны ошибки подключения к jdbc
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(config.getProperty("jdbc.driver"));
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("jdbc.url"),
                config.getProperty("jdbc.username"),
                config.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
                    preparedStatement.setString(1, user.name);
                    preparedStatement.setString(2, user.email);
                    preparedStatement.execute();
                }
            }
        }
    }

    /**
     * Класс модели данных
     */
    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    /**
     * создает объекты класса и запускает методы
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream input = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(input);
        }
        ImportDB dataBase = new ImportDB(config, "./dump.txt");
        dataBase.save(dataBase.load());
    }
}