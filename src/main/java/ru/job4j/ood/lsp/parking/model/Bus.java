package ru.job4j.ood.lsp.parking.model;

public class Bus implements Car {
    int size;

    public Bus(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
