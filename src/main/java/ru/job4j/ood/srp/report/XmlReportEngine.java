package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.Employees;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {
    private final Store store;

    public XmlReportEngine(MemoryStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            Employees employees = new Employees(store.findBy(filter));
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();
        }
        return xml;
    }
}
