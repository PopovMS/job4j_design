package ru.job4j.ood.srp;

public class UserService {
    public void createUser(User user) {
        /* Логика создания пользователя */
        System.out.println("Создан пользователь: " + user.getName());
    }

    public void updateUser(User user) {
        /* Логика обновления пользователя */
        System.out.println("Обновлен пользователь: " + user.getName());
    }

    public void deleteUser(User user) {
        /* Логика удаления пользователя */
        System.out.println("Удален пользователь: " + user.getName());
    }

    public void logAction(String action, User user) {
        /* Логирование действий пользователя */
        System.out.println("Действие: " + action + ", пользователь: " + user.getName());
    }
}
