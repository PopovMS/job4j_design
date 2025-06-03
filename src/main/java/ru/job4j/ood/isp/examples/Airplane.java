package ru.job4j.ood.isp.examples;

public class Airplane implements Vehicle {

    /**
     * Причина нарушения: Каждый тип транспорта реализует только часть методов, остальные не нужны.
     * Например, обычно самолет не может плавать
     */

    @Override
    public void drive() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void sail() {

    }

    @Override
    public void park() {

    }
}
