package org.lessons.lesson27;

public class Main  {
    public static void main(String[] args) {
        User user = new User("John", "Doe");
        Address adr = new Address("Ukraine", "Kyiv", "Vidradnyi district", "14888");
        user.setAddress(adr);
        System.out.println(user);
    }
}
