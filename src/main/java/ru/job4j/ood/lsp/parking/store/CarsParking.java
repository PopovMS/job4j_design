package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.model.Car;

import java.util.function.Predicate;

public interface CarsParking {

    public void addCar(Car car);

    public void findBy(Predicate<Car> filter);

    public void removeCar(String id);
}
