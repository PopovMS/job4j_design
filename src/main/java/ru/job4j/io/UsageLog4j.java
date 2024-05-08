package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Mikhail Popov";
        int age = 40;
        char currentYear = 2024;
        byte bt = 127;
        long lg = 10L;
        double x = 8.5;
        float y = 8.5F;
        short sh = 8;
        boolean isActive = true;
        LOG.debug("User info name : {}, age : {}, currentYear : {}, bt : {}, lg : {}, x : {}, y : {}, sh : {}, isActive : {}", name, age, currentYear, bt, lg, x, y, sh, isActive);
    }
}