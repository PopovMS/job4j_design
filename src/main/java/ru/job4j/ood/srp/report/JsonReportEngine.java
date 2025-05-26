package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.CalendarAdapterJson;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {

    private final Store store;

    public JsonReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var library = new GsonBuilder();
        library.registerTypeAdapter(Calendar.class, new CalendarAdapterJson());
        library.registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJson());
        Gson gson = library
                .setPrettyPrinting()
                .create();
        String split = (gson.toJson(store.findBy(filter)));
        return split;
    }
}
