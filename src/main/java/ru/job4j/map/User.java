package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает модель данных пользователя.
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;
    /**
     * Конструктор класса
     * @param name поле name
     * @param children поле children
     * @param birthday поле дата рождения
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}

