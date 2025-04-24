package org.lessons.lesson30;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector connector = new DatabaseConnector();
        try {
            connector.connect();
            EmployeeDAO dao = new EmployeeDAO(connector);
            dao.addEmployee("John", 30, "Developer", 95000);
            dao.addEmployee("Pork", 25, "Junior Developer", 38000);
            System.out.println("Employees (stage 1):");
            for (String emp : dao.getAllEmployees()) {
                System.out.println(emp);
            }
            dao.updateEmployee(1, "John", 30, "Tech Lead", 250000);
            System.out.println("Employees (stage 2):");
            for (String emp : dao.getAllEmployees()) {
                System.out.println(emp);
            }
            dao.deleteEmployee(2);
            System.out.println("Employees (stage 3):");
            for (String emp : dao.getAllEmployees()) {
                System.out.println(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally { connector.disconnect();}

    }
}
