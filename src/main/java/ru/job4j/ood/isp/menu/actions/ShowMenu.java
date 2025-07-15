package ru.job4j.ood.isp.menu.actions;

import ru.job4j.ood.isp.menu.Input;
import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.Output;
import ru.job4j.ood.isp.menu.PrintMenu;

public class ShowMenu implements UserAction {
    private final Output out;

    public ShowMenu(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Показать весь список задач";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        out.println("=== Список задач ===");
        new PrintMenu(out).print(menu);
        return true;
    }
}
