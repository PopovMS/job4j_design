package ru.job4j.ood.isp.menu.actions;

import ru.job4j.ood.isp.menu.*;

public class AddChild implements UserAction {
    private final Output out;
    ActionDelegate action = new ExecuteAction();

    public AddChild(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Добавить подзадачу";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        boolean result = false;
        out.println("=== Добавление новой подзадачи ===");
        String nameRoot = input.askStr("Введите имя родительской задачи: ");
        if (menu.select(nameRoot).isPresent()) {
            String nameChild = input.askStr("Введите имя подзадачи: ");
            result = menu.add(nameRoot, nameChild, action);
        } else {
            out.println("Нет родительской задачи с именем: " + nameRoot);
            result = true;
        }
        if (result) {
            out.println("Выполнено");
        }
        return result;
    }
}
