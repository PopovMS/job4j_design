package ru.job4j.ood.osp;

public class PaymentService {
    public void processPayment(CreditCard creditCard) {
        creditCard.authorize();
        creditCard.capture();
    }
}
