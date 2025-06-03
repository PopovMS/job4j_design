package ru.job4j.ood.lsp.foodstor.store;

import ru.job4j.ood.lsp.foodstor.model.Food;

public class Shop extends AbstractStore {
    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (food.getFreshLevel() >= 25 && food.getFreshLevel() < 75) {
            super.foods.add(food);
            result = true;
        }
        if (food.getFreshLevel() > 0 && food.getFreshLevel() < 25) {
            food.setPrice(food.getPrice() / 10 * 8);
            super.foods.add(food);
            result = true;
        }
        return result;
    }
}
