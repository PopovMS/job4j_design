package ru.job4j.ood.lsp.foodstor.store;


import ru.job4j.ood.lsp.foodstor.model.Food;
import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Food> findAll();

    boolean add(Food food);

    void delete(String name);

    void clear();

    List<Food> findBy(Predicate<Food> filter);
}
