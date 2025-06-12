package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

abstract class AbstractCarsParking implements CarsParking {
    private int freeSpice;
    private final int parkCellSize;
    private List<Car> cars = new ArrayList<>();


    public AbstractCarsParking(int freeSpice, int parkCellSize) {
        this.freeSpice = freeSpice;
        this.parkCellSize = parkCellSize;
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
        freeSpice -= car.getSize();
    }

    @Override
    public List<Car> findBy(Predicate<Car> filter) {
        return cars.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    @Override
    public void removeCar(String name) {
        Car result;
        Optional<Car> car = Optional.of(cars.stream()
                .filter(vol -> name.equals(vol.getName()))
                .peek(car1 -> freeSpice += car1.getSize())
                .findFirst()
                .get());
        result = car.get();
        freeSpice += result.getSize();
        cars.remove(result);
    }

        @Override
    public int getFreeSpice() {
        return freeSpice;
    }

    @Override
    public int getParkCellSize() {
        return parkCellSize;
    }
}
