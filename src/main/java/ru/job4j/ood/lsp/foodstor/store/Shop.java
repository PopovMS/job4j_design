package ru.job4j.ood.lsp.foodstor.store;

import ru.job4j.ood.lsp.foodstor.model.Food;

public class Shop extends AbstractStore {
    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (food.getFreshLevel() >= fresh25 && food.getFreshLevel() < fresh75) {
            super.add(food);
            result = true;
        }
        if (food.getFreshLevel() > 0 && food.getFreshLevel() < fresh25) {
            food.setPrice(food.getPrice() / 10 * 8);
            super.add(food);
            result = true;
        }
        return result;
    }
}
