package ru.job4j.ood.lsp.foodstor;

import ru.job4j.ood.lsp.foodstor.model.Food;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SimpleFreshLevel extends AbstractFreshLevel {

    public SimpleFreshLevel(LocalDateTime dateTime) {
        super(dateTime);
    }

    /**
     * Метод расчитывает остаток свежести продукта
     * в процентах относительно к дате
     * переданной в конструкторе класса в
     * момент запуска программы
     * @param food - принимает ссылку на объект продукта
     * @return - возвращает положительное число
     */

    @Override
    public int calcFL(Food food) {
        int fullDays = (int) (food.getCreateDate().until(food.getExpiryDate(), ChronoUnit.DAYS));
        int daysLeft = (int) (dateTime.until(food.getExpiryDate(), ChronoUnit.DAYS));
        return (int) daysLeft * 100 / fullDays;
    }
}
