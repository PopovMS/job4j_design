package ru.job4j.jdbc;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;
    private Statement statement;
    /**
     * Создает все объекты и запускает методы класса
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
        }
        TableEditor tableEditor = new TableEditor(config);
        tableEditor.createTable("beer_price");
        System.out.println(tableEditor.getTableScheme("beer_price"));

        tableEditor.addColumn("beer_price", "type_of_beer", "VARCHAR(255)");
        System.out.println(tableEditor.getTableScheme("beer_price"));

        tableEditor.renameColumn("beer_price", "type_of_beer", "Сорт_пива");
        System.out.println(tableEditor.getTableScheme("beer_price"));

        tableEditor.dropColumn("beer_price", "Сорт_пива");

        tableEditor.dropTable("beer_price");
    }
    /**
     * Конструктор класса
     * @param properties принимает класс конфига
     */
    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }
    /**
     *
     */
    private void initConnection() {
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, login, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод исполняет запрос на создание таблицы
     * @param tableName принимает имя таблицы
     */
    public void createTable(String tableName) throws SQLException {
            String sql = String.format(
                    "CREATE TABLE IF NOT EXISTS %s();", tableName
            );
            statement.execute(sql);
    }
    /**
     * создает запрос в базу для удаления таблицы
     * @param tableName принимает имя таблицы
     */
    public void dropTable(String tableName) throws SQLException {
            String sql = String.format(
                    "DROP TABLE IF EXISTS %s;", tableName
            );
            statement.execute(sql);
    }
    /**
     *создает запрос в базу для добавления колонки в таблицу
     * @param tableName принимает имя таблицы
     * @param columnName принимает имя колонки
     * @param type принимает тип колонки
     */
    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s ADD %s %s;", tableName, columnName, type
        );
        statement.execute(sql);
    }
    /**
     * Удаляет столбец из таблицы
     * @param tableName принимает имя таблицы
     * @param columnName принимает имя удаляемого столбца
     */
    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s DROP COLUMN %s;", tableName, columnName
        );
        statement.execute(sql);
    }
    /**
     * Переименовывает столбец таблицы
     * @param tableName принимает имя таблицы
     * @param columnName принимает старое имя столбца
     * @param newColumnName принимает новое имя столбца
     */
    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName
        );
        statement.execute(sql);
    }
    /**
     *Создает схему колонок таблицы
     * @param tableName получает имя таблицы
     * @return возвращает String объект со схемой таблицы
     * @throws Exception
     */
    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }
    /**
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}