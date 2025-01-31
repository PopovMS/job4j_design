package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.comparators.SalaryComparator;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.util.*;
import java.util.function.Predicate;

public class HrReportEngine implements Report {

    private final Store store;

    public HrReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> result = store.findBy(filter);
        Comparator<Employee> comparator = new SalaryComparator();
        result.sort(comparator);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : result) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}