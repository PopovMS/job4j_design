package ru.job4j.ood.lsp.foodstor;

import ru.job4j.ood.lsp.foodstor.model.Food;
import ru.job4j.ood.lsp.foodstor.store.Store;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControlQuality {
    List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    /**
     * Метод обращается за расчетом остатка свежести продукта,
     * записывает процент свежести в экземпляр объекта Food,
     * добавляет ссылку на объект Food во все хранилища списка Store
     *
     * @param food - принимает ссылку на объект Food
     */
    public void put(Food food) {
        food.setFreshLevel(calcFreshLevel(food));
        stores.forEach(store -> store.add(food));
    }

    /**
     * Метод расчитывает остаток свежести продукта в процентах.
     * @param food - принимает ссылку на объект продукта
     * @return - возвращает положительное число
     */
    private int calcFreshLevel(Food food) {
        int fullDays = (int) (food.getCreateDate().until(food.getExpiryDate(), ChronoUnit.DAYS));
        int daysLeft = (int) (LocalDateTime.now().until(food.getExpiryDate(), ChronoUnit.DAYS));
        return (int) daysLeft * 100 / fullDays;
    }
}
