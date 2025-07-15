package ru.job4j.ood.isp.menu;

public class ExecuteAction implements ActionDelegate {

    @Override
    public void delegate() {
        new ConsoleOutput().println("Выполнение какого-то действия");
    }
}
