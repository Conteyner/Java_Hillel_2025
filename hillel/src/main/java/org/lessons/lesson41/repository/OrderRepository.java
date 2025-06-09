package org.lessons.lesson41.repository;

import org.lessons.lesson41.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
