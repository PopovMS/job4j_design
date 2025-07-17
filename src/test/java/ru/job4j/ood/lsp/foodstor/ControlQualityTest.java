package ru.job4j.ood.lsp.foodstor;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstor.model.Food;
import ru.job4j.ood.lsp.foodstor.model.Milk;
import ru.job4j.ood.lsp.foodstor.store.Shop;
import ru.job4j.ood.lsp.foodstor.store.Store;
import ru.job4j.ood.lsp.foodstor.store.Trash;
import ru.job4j.ood.lsp.foodstor.store.Warehouse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class ControlQualityTest {

    @Test
    public void whenMilkGoToWarehouse() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        Warehouse whouse = new Warehouse();
        Trash trash = new Trash();
        store.add(shop);
        store.add(whouse);
        store.add(trash);
        Food milk = new Milk("Prostokvashino",
                LocalDateTime.of(2025, 7, 20, 0, 0),
                LocalDateTime.of(2025, 8, 29, 0, 0));
        milk.setPrice(120);
        ControlQuality service = new ControlQuality(store);
        LocalDateTime dateTime = LocalDateTime.now();
        service.put(milk, new SimpleFreshLevel(dateTime));
        assertThat("Prostokvashino").isEqualTo(whouse.findAll().get(0).getName());
    }

    @Test
    public void whenMilkGoToShop() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        Warehouse whouse = new Warehouse();
        Trash trash = new Trash();
        store.add(shop);
        store.add(whouse);
        store.add(trash);
        Food milk = new Milk("Prostokvashino",
                LocalDateTime.of(2025, 7, 10, 0, 0),
                LocalDateTime.of(2025, 7, 20, 0, 0));
        milk.setPrice(120);
        ControlQuality service = new ControlQuality(store);
        LocalDateTime dateTime = LocalDateTime.now();
        service.put(milk, new SimpleFreshLevel(dateTime));
        assertThat("Prostokvashino").isEqualTo(shop.findAll().get(0).getName());
    }

    @Test
    public void whenMilkGoToTrash() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        Warehouse whouse = new Warehouse();
        Trash trash = new Trash();
        store.add(shop);
        store.add(whouse);
        store.add(trash);
        Food milk = new Milk("Prostokvashino",
                LocalDateTime.of(2025, 5, 20, 0, 0),
                LocalDateTime.of(2025, 5, 29, 0, 0));
        milk.setPrice(120);
        ControlQuality service = new ControlQuality(store);
        LocalDateTime dateTime = LocalDateTime.now();
        service.put(milk, new SimpleFreshLevel(dateTime));
        assertThat("Prostokvashino").isEqualTo(trash.findAll().get(0).getName());
    }

    @Test
    public void whenMilkGoToWarehouseAndThenResort() {
        List<Store> store = new ArrayList<>();
        Shop shop = new Shop();
        Warehouse whouse = new Warehouse();
        Trash trash = new Trash();
        store.add(shop);
        store.add(whouse);
        store.add(trash);
        Food milk = new Milk("Prostokvashino",
                LocalDateTime.of(2025, 7, 17, 0, 0),
                LocalDateTime.of(2025, 7, 30, 0, 0));
        milk.setPrice(120);
        ControlQuality service = new ControlQuality(store);
        LocalDateTime dateTime = LocalDateTime.now();
        service.put(milk, new SimpleFreshLevel(dateTime));
        dateTime = LocalDateTime.of(2025, 7, 28, 0, 0);
        service.resort(new SimpleFreshLevel(dateTime));
        assertThat("Prostokvashino").isEqualTo(shop.findAll().get(0).getName());
    }
}