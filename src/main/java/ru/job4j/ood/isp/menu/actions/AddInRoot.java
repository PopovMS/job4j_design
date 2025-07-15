package ru.job4j.ood.isp.menu.actions;

import ru.job4j.ood.isp.menu.*;

public class AddInRoot implements UserAction {
    private final Output out;
    ActionDelegate action = new ExecuteAction();

    public AddInRoot(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "Добавить задачу";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        out.println("=== Добавление новой задачи ===");
        String name = input.askStr("Введите имя: ");
        boolean result = menu.add(Menu.ROOT, name, action);
        if (result) {
            out.println("Выполнено");
        } else {
            out.println("Не выплнено");
        }
        return result;
    }
}
