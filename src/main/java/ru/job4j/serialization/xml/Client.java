package ru.job4j.serialization.xml;



import javax.xml.bind.annotation.*;

@XmlRootElement(name = "client")
public class Client {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean mainOffice;
    @XmlAttribute
    private int numberDep;
    @XmlAttribute
    private String phone;

    public Client(String name, boolean mainOffice, int numberDep, String phone) {
        this.name = name;
        this.mainOffice = mainOffice;
        this.numberDep = numberDep;
        this.phone = phone;
    }

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{"
                + "name='" + name + '\''
                + ", mainOffice=" + mainOffice
                + ", numberDep=" + numberDep
                + ", phone='" + phone + '\''
                + '}';
    }
}
