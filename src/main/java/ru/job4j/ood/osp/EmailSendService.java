package ru.job4j.ood.osp;

public class EmailSendService implements SendService {
    @Override
    public void sendMessage(String recipient, String message) {
        /* Логика отправки почтового сообщения */
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}
