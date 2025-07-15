package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.actions.*;

import java.util.List;

public class TodoApp {
    private final Output out;

    public TodoApp(Output out) {
        this.out = out;
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(
                output, new ConsoleInput()
        );
        Menu menu = new SimpleMenu();
        List<UserAction> actions = List.of(
                new AddInRoot(output),
                new AddChild(output),
                new ShowMenu(output),
                new CallAction(output),
                new Exit(output)
        );
        new TodoApp(output).init(input, menu, actions);
    }

    public void init(Input input, Menu menu, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, menu);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Меню:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }

    }
}
