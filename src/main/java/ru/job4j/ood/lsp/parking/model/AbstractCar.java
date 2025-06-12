package ru.job4j.ood.lsp.parking.model;

abstract class AbstractCar implements Car {
    private String name;
    private int size = 1;
    private int id;

    public AbstractCar(String name) {
        this.name = name;
    }

    public AbstractCar(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}
