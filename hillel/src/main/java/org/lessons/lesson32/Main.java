package org.lessons.lesson32;

import org.lessons.lesson32.coffee.order.CoffeeOrderBoard;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Nick");
        coffeeOrderBoard.add("Bob");
        coffeeOrderBoard.add("Jack");
        coffeeOrderBoard.add("Tom");
        coffeeOrderBoard.add("Jack");
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(2);
        coffeeOrderBoard.draw();

    }
}
