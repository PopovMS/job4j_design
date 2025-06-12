package ru.job4j.ood.lsp.parking.service;

import ru.job4j.ood.lsp.parking.model.Car;

public interface ParkService {

    boolean park(Car car);

    void unpark(String name);
}
