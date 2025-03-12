package org.lessons.PetrolStation.enhanced;

public class Car implements Runnable{
    private String number;
    private int tankCapacity;
    private int currentFuel;
    private EnhancedPetrolStation station;

    //Generate random tank and fuel parameters
    public Car(String number, EnhancedPetrolStation station) {
        this.number = number;
        this.tankCapacity = 30 + (int) (Math.random() * 40); // 30-70
        this.currentFuel = (int) (Math.random() * (tankCapacity / 2.0)); // min = 0; max = tankCapacity * 1/2
        this.station = station;
    }


    //Running the car in a separate thread
    @Override
    public void run() {
        int requiredFuel = getRequiredFuel();
        if (requiredFuel > 0) {
            System.out.println(
                    "The car " + number +
                            " that fuelled by " + currentFuel + "/" + tankCapacity +
                            " is going to refuel on " + requiredFuel + " litres of petrol."
            );
            station.addCarToQueue(this);
        } else {
            System.out.println("Does not require refuelling " + number);
        }
    }

    public int getRequiredFuel() {
        return tankCapacity - currentFuel;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public String getNumber() {
        return number;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }
}
