package ru.job4j.ood.lsp.foodstor;

import ru.job4j.ood.lsp.foodstor.model.Food;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FreshLevel {


    /**
     * Метод расчитывает остаток свежести продукта в процентах.
     * @param food - принимает ссылку на объект продукта
     * @return - возвращает положительное число
     */
    public int calcFL(Food food) {
        int fullDays = (int) (food.getCreateDate().until(food.getExpiryDate(), ChronoUnit.DAYS));
        int daysLeft = (int) (LocalDateTime.now().until(food.getExpiryDate(), ChronoUnit.DAYS));
        return (int) daysLeft * 100 / fullDays;
    }
}
