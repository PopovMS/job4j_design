package ru.job4j.ood.lsp.parking.service;

import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.store.CarsParking;

public class SimpleParkService implements ParkService {
    private CarsParking[] cp;

    public SimpleParkService(CarsParking[] carsParkings) {
        this.cp = carsParkings;
    }

    @Override
    public boolean park(Car car) {
        boolean result = false;
        for (int index = 0; index < cp.length; index++) {
            if ((cp[index].getParkCellSize() <= car.getSize() && cp[index].getFreeSpice() >= car.getSize())) {
                cp[index].addCar(car);
                result = true;
                break;
            }
            if (index != cp.length - 1) {
                if (cp[index + 1].getFreeSpice() < car.getSize()) {
                    cp[index].addCar(car);
                    result = true;
                    break;
                }
            } else if (cp[index].getFreeSpice() >= car.getSize()) {
                cp[index].addCar(car);
                result = true;
            }
        }
        return result;
    }

    @Override
    public void unpark(String name) {
        for (CarsParking carsParking : cp) {
            carsParking.removeCar(name);
        }
    }
}
