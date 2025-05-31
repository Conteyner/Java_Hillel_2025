package org.lessons.lesson39.dao;

import org.lessons.lesson39.mapper.CustomerMapper;
import org.lessons.lesson39.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCustomer(Customer customer) {
        String sql = """
            INSERT INTO Customer (full_name, email, social_security_number)
            VALUES (?, ?, ?)
        """;
        jdbcTemplate.update(
                sql,
                customer.getFullName(),
                customer.getEmail(),
                customer.getSocialSecurityNumber()
        );
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        String sql = """
            UPDATE Customer
            SET full_name = ?, email = ?, social_security_number = ?
            WHERE id = ?
        """;
        int rowsAffected = jdbcTemplate.update(
                sql,
                customer.getFullName(),
                customer.getEmail(),
                customer.getSocialSecurityNumber(),
                customer.getId()
        );
        return rowsAffected > 0;
    }

    @Override
    public boolean deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
        return Optional.ofNullable(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, new CustomerMapper());
    }
}
