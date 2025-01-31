package ru.job4j.ood.osp;

public class AmexCreditCard extends CreditCard {
    @Override
    public void authorize() {
        System.out.println("Authorizing AMEX payment");
    }

    @Override
    public void capture() {
        System.out.println("Capturing AMEX payment");
    }
}