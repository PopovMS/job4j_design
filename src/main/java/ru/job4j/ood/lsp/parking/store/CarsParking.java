package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.model.Car;

import java.util.List;
import java.util.function.Predicate;

public interface CarsParking {

    void addCar(Car car);

    List<Car> findBy(Predicate<Car> filter);

    void removeCar(String id);

    int getFreeSpice();

    int getParkCellSize();
}
