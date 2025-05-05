package org.lessons.lesson32.coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CoffeeOrderBoard {
    private static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);

    private final List<Order> list = new LinkedList<>();
    private final AtomicInteger count = new AtomicInteger(0);

    public void add(String customerName) {
        int index = count.incrementAndGet();
        Order order = new Order(index, customerName);
        list.add(order);
        logger.info("Added new order: {}", order);

    }

    public Order deliver(){
        if(list.isEmpty()) {
            logger.warn("Nothing to deliver");
            return null;
        }
        Order order = list.remove(0);
        logger.info("Delivered order: {}", order);
        return order;
    }

    public Order deliver(int index){
        Iterator<Order> iterator = list.iterator();
        while(iterator.hasNext()){
            Order order = iterator.next();
            if(order.getOrderId() == index){
                iterator.remove();
                logger.info("Delivered order: {}", order);
                return order;
            }
        }
        logger.warn("Nothing to deliver");
        return null;
    }

    public void draw(){
        logger.info("Drawing orders...");
        if (list.isEmpty()) {
            logger.info("Nothing to draw");
            System.out.println("Nothing to draw");
        }

        String line = "+-------+--------------------------+";
        String header = "| %-5s | %-24s |%n";
        String row = "| %-5d | %-24s |%n";

        System.out.println(line);
        System.out.printf(header, "Num", "Name");
        System.out.println(line);

        for(Order order : list){
            System.out.printf(row, order.getOrderId(), order.getCustomerName());
        }

        System.out.println(line);
    }


}
