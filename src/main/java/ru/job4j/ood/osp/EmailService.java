package ru.job4j.ood.osp;

public class EmailService {
    public void sendEmail(String recipient, String message) {
        /* Логика отправки email */
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}
