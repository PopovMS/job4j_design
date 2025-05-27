package ru.job4j.ood.lsp;

public class Car extends Vehicle {
    private int currentDistance = 0;

    @Override
    public void move(int distance) {
        currentDistance += distance; // сохраняет пройденное расстояние
    }
}
