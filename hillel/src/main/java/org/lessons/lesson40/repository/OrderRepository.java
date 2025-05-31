package org.lessons.lesson40.repository;

import org.lessons.lesson40.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orders = new HashMap<Long, Order>();

    public Optional<Order> findById(long id) {
        return Optional.ofNullable(orders.get(id));
    }
    public List<Order> findAll() {
        return new ArrayList<Order>(orders.values());
    }
    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }
}
