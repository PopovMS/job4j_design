package ru.job4j.ood.osp;

public class NotificationService {
    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendNotification(String recipient, String message) {
        emailService.sendEmail(recipient, message);
        System.out.println("Notification sent");
    }
}
