package ru.job4j.ood.lsp.foodstor;

import ru.job4j.ood.lsp.foodstor.model.Food;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AbstractFreshLevel implements FreshLevel {
    LocalDateTime dateTime;

    public AbstractFreshLevel(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int calcFL(Food food) {
        int fullDays = (int) (food.getCreateDate().until(food.getExpiryDate(), ChronoUnit.DAYS));
        int daysLeft = (int) (dateTime.until(food.getExpiryDate(), ChronoUnit.DAYS));
        return (int) daysLeft * 100 / fullDays;
    }
}
