package org.lessons.lesson40.controller;

import org.lessons.lesson40.model.Order;
import org.lessons.lesson40.model.Product;
import org.lessons.lesson40.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable long id) {
        return orderRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        List<Product> products = order.getProducts().stream().map(dto -> new Product(dto.getId(),dto.getName(),dto.getCost())).toList();
        double sum = products.stream()
                .mapToDouble(Product::getCost)
                .sum();

        Order newOrder = new Order(order.getId(), LocalDateTime.now(),sum ,products);

        return ResponseEntity.ok(orderRepository.save(newOrder));
    }

}

