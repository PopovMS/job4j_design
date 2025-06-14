package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;

import javax.xml.bind.JAXBException;
import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter) throws JAXBException, Exception;
}