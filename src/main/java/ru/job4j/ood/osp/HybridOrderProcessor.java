package ru.job4j.ood.osp;

public class HybridOrderProcessor implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        System.out.println("Processing hybrid order");
    }
}
