package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.model.Car;

import java.util.List;
import java.util.function.Predicate;

public interface CarsParking {

    public void addCar(Car car);

    public List<Car> findBy(Predicate<Car> filter);

    public Car findById(String id);

    public void removeCar(String id);

    public int getFreeSpice();
}
