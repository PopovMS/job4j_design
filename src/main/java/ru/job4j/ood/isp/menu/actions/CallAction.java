package ru.job4j.ood.isp.menu.actions;

import ru.job4j.ood.isp.menu.*;

public class CallAction implements UserAction {
    private final Output out;
    ActionDelegate action = new ExecuteAction();

    public CallAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Вызвать действие";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        boolean result = false;
        out.println("=== Вызвать действие ===");
        String name = input.askStr("Введите имя задачи: ");
        if (menu.select(name).isPresent()) {
            menu.select(name).get().getActionDelegate();
        } else {
            out.println("Нет задачи с именем: " + name);
            result = true;
        }
        if (result) {
            out.println("Выполнено");
        }
        return result;
    }
}
