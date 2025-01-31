package ru.job4j.ood.osp;

public class DigitalOrderProcessor implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        System.out.println("Processing digital order");
    }
}
