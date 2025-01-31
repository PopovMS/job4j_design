package ru.job4j.ood.osp;

public class OrderProcessingSystem {
    private OrderProcessor processor;

    public OrderProcessingSystem(OrderProcessor processor) {
        this.processor = processor;
    }

    public void processOrder(Order order) {
        processor.processOrder(order);
    }
}
