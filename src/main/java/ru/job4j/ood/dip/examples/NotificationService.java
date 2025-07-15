package ru.job4j.ood.dip.examples;

public class NotificationService {
    private EmailSender emailSender;

    public NotificationService() {
        this.emailSender = new EmailSender(); /* Зависимость от конкретной реализации отправки */
    }

    public void sendNotification(String recipient, String message) {
        emailSender.send(recipient, message);
    }
}

class EmailSender {
    public void send(String recipient, String message) {
        System.out.println("Отправляем email: " + message);
    }
}

/*
Причина нарушения:
1. Зависимость от конкретной реализации отправки email
2. Отсутствие гибкости при добавлении новых способов уведомления
3. Сложность тестирования
*/