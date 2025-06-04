package ru.job4j.ood.lsp.parking.service;

import ru.job4j.ood.lsp.parking.model.Car;

public class SimpleParkService implements ParkService {
    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean unpark(Car car) {
        return false;
    }
}
