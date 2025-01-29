package ru.job4j.ood.srp;

public class Report {
    public String generateReport() {
        /* Логика генерации отчета */
        return "Отчет: " + getFormattedReport();
    }

    public String getFormattedReport() {
        /* Логика форматирования отчета */
        return "Форматированный отчет";
    }
}
