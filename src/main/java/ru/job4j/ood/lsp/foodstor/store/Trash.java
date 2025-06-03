package ru.job4j.ood.lsp.foodstor.store;

import ru.job4j.ood.lsp.foodstor.model.Food;

public class Trash extends AbstractStore {
    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (food.getFreshLevel() <= 0) {
            super.foods.add(food);
            result = true;
        }
        return result;
    }
}
