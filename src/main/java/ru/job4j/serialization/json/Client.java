package ru.job4j.serialization.json;



public class Client {
    private final String name;
    private final boolean mainOffice;
    private final int numberDep;
    private final String phone;

    public Client(String name, boolean mainOffice, int numberDep, String phone) {
        this.name = name;
        this.mainOffice = mainOffice;
        this.numberDep = numberDep;
        this.phone = phone;
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
