package ru.job4j.ood.osp;

public class NotificationService {
    private EmailSendService emailService;

    public NotificationService(EmailSendService emailService) {
        this.emailService = emailService;
    }
    public void sendNotification(String recipient, String message) {
        emailService.sendMessage(recipient, message);
        System.out.println("Notification sent");
    }
}
