package ru.job4j.ood.lsp.foodstor;

import ru.job4j.ood.lsp.foodstor.model.Food;
import ru.job4j.ood.lsp.foodstor.store.Store;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlQuality {
    private List<Store> stores;
    LocalDateTime dateTime;

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
    public void put(Food food, FreshLevel freshLevel) {
        food.setFreshLevel(freshLevel.calcFL(food));
        stores.forEach(store -> store.add(food));
    }

    public void resort(FreshLevel freshLevel) {
        List<Food> tempStore = new ArrayList<>();
        for (Store store : stores) {
            tempStore.addAll(store.findAll());
            store.clear();
        }

        tempStore.forEach(vol -> put(vol, freshLevel));
    }
}
