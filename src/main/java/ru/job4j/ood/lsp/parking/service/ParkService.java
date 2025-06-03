package ru.job4j.ood.lsp.parking.service;

import ru.job4j.ood.lsp.parking.model.Car;

public interface ParkService {

    public boolean park(Car car);

    public boolean unpark(Car car);
}
