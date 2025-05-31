package org.lessons.lesson39.dao;

import org.lessons.lesson39.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    void addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
    Optional<Customer> getCustomerById(int id);
    List<Customer> getAllCustomers();
}

