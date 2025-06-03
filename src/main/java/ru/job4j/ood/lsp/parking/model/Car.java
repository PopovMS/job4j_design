package ru.job4j.ood.lsp.parking.model;

public interface Car {

    default int getSize() {
        return 1;
    }
}
