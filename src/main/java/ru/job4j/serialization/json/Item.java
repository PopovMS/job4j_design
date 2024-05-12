package ru.job4j.serialization.json;

import java.util.Arrays;

public class Item {
    private final int id;
    private final String name;
    private final String desc;
    private final boolean isActive;
    private final String[] dateOfChange;
    private final Client client;


    public Item(int id, String name, String desc, boolean isActive, String[] dateOfChange, Client client) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.isActive = isActive;
        this.dateOfChange = dateOfChange;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", decs='" + desc + '\''
                + ", isActive=" + isActive
                + ", dateOfChange=" + Arrays.toString(dateOfChange)
                + ", client=" + client.toString()
                + '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isActive() {
        return isActive;
    }

    public String[] getDateOfChange() {
        return dateOfChange;
    }

    public Client getClient() {
        return client;
    }
}
