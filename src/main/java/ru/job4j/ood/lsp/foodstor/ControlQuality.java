package ru.job4j.ood.lsp.foodstor;

import ru.job4j.ood.lsp.foodstor.model.Food;
import ru.job4j.ood.lsp.foodstor.store.Store;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControlQuality {
    private List<Store> stores;
    FreshLevel freshLevel;

    public ControlQuality(List<Store> stores, FreshLevel freshLevel) {
        this.stores = stores;
        this.freshLevel = freshLevel;
    }

    /**
     * Метод обращается за расчетом остатка свежести продукта,
     * записывает процент свежести в экземпляр объекта Food,
     * добавляет ссылку на объект Food во все хранилища списка Store
     *
     * @param food - принимает ссылку на объект Food
     */
    public void put(Food food) {
        food.setFreshLevel(freshLevel.calcFL(food));
        stores.forEach(store -> store.add(food));
    }
}
