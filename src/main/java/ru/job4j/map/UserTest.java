package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(946666800000L);
        User user1 = new User("Ivan", 21, calendar);
        User user2 = new User("Ivan", 21, calendar);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1.equals(user2));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
}
