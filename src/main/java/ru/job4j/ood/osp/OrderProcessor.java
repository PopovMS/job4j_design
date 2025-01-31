package ru.job4j.ood.osp;

public class OrderProcessor {
    public void processOrder(Order order) {
        if (order.getType().equals("PHYSICAL")) {
            processPhysicalOrder(order);
        } else if (order.getType().equals("DIGITAL")) {
            processDigitalOrder(order);
        }
    }

    private void processPhysicalOrder(Order physicalOrder) {
        System.out.println("Processing physical order");
    }

    private void processDigitalOrder(Order digitalOrder) {
        System.out.println("Processing digital order");
    }
}
