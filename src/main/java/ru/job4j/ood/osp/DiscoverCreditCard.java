package ru.job4j.ood.osp;

public class DiscoverCreditCard implements CreditCard {
    @Override
    public void authorize() {
        System.out.println("Authorizing Discover payment");
    }

    @Override
    public void capture() {
        System.out.println("Capturing Discover payment");
    }
}
