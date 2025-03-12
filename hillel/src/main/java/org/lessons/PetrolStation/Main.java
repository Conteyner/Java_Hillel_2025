package org.lessons.PetrolStation;

import org.lessons.PetrolStation.enhanced.Car;
import org.lessons.PetrolStation.enhanced.EnhancedPetrolStation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        runDefaultVersion();
        //runEnhancedVersion();
    }

    public static void runDefaultVersion(){
        PetrolStation station = new PetrolStation(250);

        for (int i = 1; i <= 10; i++) {
            int fuelAmount = 10 + (int)(Math.random() * 31);
            station.doRefuel(fuelAmount);
        }
    }

    //"Enhanced" version | Dont touch. Dead
    public static void runEnhancedVersion(){
        //TODO: catch and fix 100500 bugs
        EnhancedPetrolStation station = new EnhancedPetrolStation(250);

        ExecutorService executor = Executors.newFixedThreadPool(5); //Pool for 5 threads to build cars. not for refuelling
        for (int i = 1; i <= 10; i++) {
            executor.execute(new Car("Car " + i, station));
        }
        executor.shutdown();
    }

}



