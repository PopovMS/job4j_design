package ru.job4j.ood.lsp.foodstor.store;

import ru.job4j.ood.lsp.foodstor.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AbstractStore implements Store {

    private List<Food> foods = new ArrayList<>();
    public final int fresh0 = 25;
    public final int fresh25 = 25;
    public final int fresh75 = 75;

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public boolean add(Food food) {
        return foods.add(food);
    }

    @Override
    public void delete(String name) {
        foods.remove(findBy(food -> name.equals(food.getName())));

    }

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return foods.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
