package org.lessons.lesson_2;

import java.util.Scanner;

public class Main {
    private static final double CONV_D = 1.609344;

    public static void main(String[] args) {
        System.out.println("This program converts miles to kilometers and vice versa.");

        Scanner sc = new Scanner(System.in);
        System.out.println("First of all: what do you want to convert?\n1.Miles --> Km\n2.Km --> Miles");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter miles: ");
                double miles = sc.nextDouble();
                double km = convertMilesToKilometers(miles);
                System.out.println("Converted successfully: " + km);
            }
            case 2 -> {
                System.out.println("Enter kilometers: ");
                double km = sc.nextDouble();
                double miles = convertKilometersToMiles(km);
                System.out.println("Converted successfully: " + miles);
            }
            default -> System.out.println("Invalid choice. You`ve entered bullshit.");
        }
    }

    private static double convertMilesToKilometers(double miles) {
        return miles * CONV_D;
    }

    private static double convertKilometersToMiles(double km) {
        return km / CONV_D;
    }
}