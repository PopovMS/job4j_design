package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2000, 0, 1);
        User user1 = new User("Ivan", 21, calendar);
        User user2 = new User("Ivan", 21, calendar);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
}
