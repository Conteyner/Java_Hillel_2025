package org.lessons.PetrolStation.enhanced;

import java.util.concurrent.*;

public class EnhancedPetrolStation {
    private int amount;
    private final BlockingQueue<Car> queue = new LinkedBlockingQueue<>(); // Internal queue, where we stack cars
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public EnhancedPetrolStation(int amount) {
        this.amount = amount;
        startProcessingQueue(); //a flow that takes cars from the queue
    }

    //car calls addCarToQueue() to queue
    public void addCarToQueue(Car car) {
        try {
            queue.put(car);
            System.out.println(car.getNumber() + " is waiting in queue...");
            System.out.println("Queue size: " + queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //runs a separate thread that picks up cars from the queue non-stop and passes them on to the petrol station
    private void startProcessingQueue() {
        new Thread(() -> {
            while (true) {
                try {
                    Car car = queue.take(); // take car from the queue
                    executorService.execute(() -> doRefuel(car)); // Transferring the task to refuelling
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void doRefuel(Car car) {
        // Getting access to ThreadPoolExecutor to find out active threads
        ThreadPoolExecutor activePool = (ThreadPoolExecutor) executorService;
        int activeThreads = activePool.getActiveCount();

        int fuelAmount = car.getRequiredFuel();
        System.out.println("The car " + car.getNumber() + " is waiting to refuel... "
                + "(Active threads: " + activeThreads + ")");

        try {
            System.out.println("The car " + car.getNumber() + " is waiting to refuel...");
            if(amount >= fuelAmount) {
                System.out.println("The car " + car.getNumber() + " is refuelling...");
                Thread.sleep(3000 + (int) (Math.random() * 7000));
                amount -= fuelAmount;
                System.out.println("The car " + car.getNumber() + " is refuelled! Fuel left: " + amount + " litres.");

                // If the fuel runs out. Immediate stop the station

                if(amount <= 0) {
                    System.out.println("Station is out of fuel. Immediate shutdown...");
                    executorService.shutdown();
                }
            } else {
                System.out.println(car.getNumber() + " couldn't refuel! Not enough fuel.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
