package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.model.Car;

import java.util.List;
import java.util.function.Predicate;

abstract class AbstractCarsParking implements CarsParking {
    int freeSpice;

    public AbstractCarsParking(int freeSpice) {
        this.freeSpice = freeSpice;
    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public List<Car> findBy(Predicate<Car> filter) {
        return null;
    }

    @Override
    public Car findById(String id) {
        return null;
    }

    @Override
    public void removeCar(String id) {

    }

    @Override
    public int getFreeSpice() {
        return freeSpice;
    }
}
