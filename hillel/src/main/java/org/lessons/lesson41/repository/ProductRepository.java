package org.lessons.lesson41.repository;

import org.lessons.lesson41.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
