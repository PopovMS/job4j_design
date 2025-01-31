package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


class HrReportEngineTest {

    @Test
    public void reportForHr() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        List<Employee> inboxlist = Arrays.asList(
                new Employee("Ivan", now, now, 100000),
                new Employee("Petr", now, now, 1000000),
                new Employee("Mikhail", now, now, 200000));
        List<Employee> expectedList = Arrays.asList(
                new Employee("Petr", now, now, 1000000),
                new Employee("Mikhail", now, now, 200000),
                new Employee("Ivan", now, now, 100000));

        inboxlist.forEach(store::add);
        Report engine = new HrReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : expectedList) {
            expected.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }

        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}