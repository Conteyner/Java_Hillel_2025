package org.lessons.lesson27;

public class User {
    private String name;
    private String surname;
    private Address address;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + address;
    }
}
