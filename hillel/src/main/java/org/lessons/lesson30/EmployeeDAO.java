package org.lessons.lesson30;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final DatabaseConnector connector;

    public EmployeeDAO(DatabaseConnector connector) {
        this.connector = connector;
    }

    public void addEmployee(String name, int age, String position, float salary) throws SQLException {
        try (PreparedStatement stmt = connector.getConnection().prepareStatement("INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, position);
            stmt.setFloat(4, salary);
            stmt.executeUpdate();
        }
    }

    public void updateEmployee(int id, String name, int age, String position, float salary) throws SQLException {
        try (PreparedStatement stmt = connector.getConnection().prepareStatement("UPDATE employees SET name=?, age=?, position=?, salary=? WHERE id=?")) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, position);
            stmt.setFloat(4, salary);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        try (PreparedStatement stmt = connector.getConnection().prepareStatement("DELETE FROM employees WHERE id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllEmployees() throws SQLException {
        List<String> result = new ArrayList<>();
        try (Statement st = connector.getConnection().createStatement()){
         try( ResultSet resultSet = st.executeQuery("SELECT * FROM employees")) {
            while (resultSet.next()) {
                result.add(resultSet.getInt("id") + ": " +
                        resultSet.getString("name") + ", " +
                        resultSet.getInt("age") + " y.o., " +
                        resultSet.getString("position") + ", $" +
                        resultSet.getFloat("salary"));
            }
        }
        return result;
    }
    }





}
