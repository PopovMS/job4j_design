package ru.job4j.serialization.xml;


import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)

public class Item {
    @XmlAttribute
    private int id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String desc;
    @XmlAttribute
    private boolean isActive;
    @XmlElementWrapper(name = "dateOfChanges")
    @XmlElement(name = "dateOfChange")
    private String[] dateOfChange;
    private Client client;


    public Item(int id, String name, String desc, boolean isActive, String[] dateOfChange, Client client) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.isActive = isActive;
        this.dateOfChange = dateOfChange;
        this.client = client;
    }

    public Item() {
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
}
