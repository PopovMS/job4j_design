package ru.job4j.ood.osp;

public class PhysicalOrderProcessor implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        System.out.println("Processing physical order");
    }
}
