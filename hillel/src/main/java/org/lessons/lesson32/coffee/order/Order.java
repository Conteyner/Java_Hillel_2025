package org.lessons.lesson32.coffee.order;

import lombok.Data;

@Data
public class Order {
    private final int orderId;
    private final String customerName;

    public Order(int orderId, String customerName) {
        if (customerName == null){
            throw new NullPointerException("customerName is null");
        }
        this.orderId = orderId;
        this.customerName = customerName;

    }
}
