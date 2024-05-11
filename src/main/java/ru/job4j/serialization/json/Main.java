package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Item item = new Item(35501, "notWorkSBIS",
                "need update SBIS-client",
                true,
                new String[] {"9.05.24", "11.05.24"},
                new Client("Ivanov", true, 7, "251"));

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(item));

        /*Создаём новую json-строку с модифицированными данными*/
        final String itemJson =
                "{"
                        + "\"id\":35502,"
                        + "\"name\":\"notBootOS\","
                        + "\"desc\":\"BlueScreen\","
                        + "\"isActive\":true,"
                        + "\"dateOfChange\":"
                        + "[\"10.05.24\",\"11.05.24\"],"
                        + "\"client\":"
                        + "{"
                        + "\"name\":\"Petrov\","
                        + "\"mainOffice\":true,"
                        + "\"numberDep\":7,"
                        + "\"phone\":\"255\""
                        + "}"
                        + "}";
        /* Превращаем json-строку обратно в объект */
        final Item itemMod = gson.fromJson(itemJson, Item.class);
        System.out.println(itemMod);
    }
}