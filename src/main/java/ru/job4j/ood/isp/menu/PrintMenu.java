package ru.job4j.ood.isp.menu;

public class PrintMenu implements MenuPrinter {
    private final Output out;

    public PrintMenu(Output out) {
        this.out = out;
    }


    @Override
    public void print(Menu menu) {
        menu.forEach(vol -> out.println(printNumbering(vol.getNumber()) + vol.getName()));
    }

    /**
     * Метод подставляет отступы ввиде тире
     * в зависимости от количества символов в нумрации пункта меню.
     * @param vol принимает значение пункта меню
     * @return возвращает результат с отступами
     */
    private String printNumbering(String vol) {
        String indent = "-";
        StringBuilder result = new StringBuilder();
        if (vol.length() > 2) {
            result.append(indent.repeat(vol.length()));
        }
        return result.append(vol).append(" ").toString();
    }
}
