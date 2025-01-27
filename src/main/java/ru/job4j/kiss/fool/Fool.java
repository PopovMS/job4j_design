package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    private static String result;
    public static void main(String[] args) {
        Fool game = new Fool();
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(game.check(startAt));
            startAt++;
            var answer = input.nextLine();
                if (!game.check(startAt).equals(answer)) {
                    System.out.println("Ошибка. Начинай снова.");
                    startAt = 0;
                }
            startAt++;
        }
    }
    public String check(int value) {
        if (value % 15 == 0) {
            result = "FizzBuzz";
        } else if (value % 3 == 0) {
            result = "Fizz";
        } else if (value % 5 == 0) {
            result = "Buzz";
        } else {
            result = String.valueOf(value);
        }
        return result;
    }
}
