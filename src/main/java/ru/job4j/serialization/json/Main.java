package ru.job4j.serialization.json;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonClient = new JSONObject("{\"name\":\"Petrov\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("11.05.24");
        list.add("12.05.24");
        JSONArray jsonDateOfChange = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Item item = new Item(35501, "notWorkSBIS",
                "need update SBIS-client",
                true,
                new String[] {"9.05.24", "11.05.24"},
                new Client("Ivanov", true, 7, "251")
                );
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("IsActive", item.isActive());
        jsonObject.put("name", item.getName());
        jsonObject.put("client", jsonClient);
        jsonObject.put("dateOfChange", jsonDateOfChange);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(item));
    }
}