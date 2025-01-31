package ru.job4j.ood.srp.comparators;

import ru.job4j.ood.srp.model.Employee;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o2.getSalary() - o1.getSalary());
    }
}
