package org.lessons.PetrolStation;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class PetrolStation {
    private int amount;
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(); // Internal queue where we stack refuelling requests
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public void doRefuel(int fuelAmount) {
        try {
            queue.put(fuelAmount); // Add the request to the queue
            System.out.println("A request of " + fuelAmount + " litres is added to the queue...");
            System.out.println("Queue size: " + queue.size());
            executor.execute(() -> {
                try {
                    int requestedFuel = queue.take(); // take queue value
                    System.out.println("The request of " + requestedFuel + " litres is waiting to refuel...");

                    Thread.sleep(3000 + (int) (Math.random() * 7000));

                    if (amount >= requestedFuel) {
                        amount -= requestedFuel;
                        System.out.println("The request of " + requestedFuel + " litres is refuelling...");
                        System.out.println("The request of " + requestedFuel + " litres is refuelled! "
                                + "Fuel left: " + amount + " litres.");
                    } else {
                        System.out.println("The request of " + requestedFuel
                                + " couldn't refuel. Not enough fuel. Fuel left: " + amount);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
