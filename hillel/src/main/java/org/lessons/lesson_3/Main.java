package org.lessons.lesson_3;

import java.util.Scanner;

public class Main {
    private static final double CONV_CELSIUS = 32; //constant for the formula

    public static void main(String[] args) {
        System.out.println("This program converts fahrenheit to celsius and vice versa");

        Scanner sc = new Scanner(System.in);
        System.out.println("First of all: what do you want to convert?\n1.fahrenheit --> celsius\n2.celsius --> fahrenheit");
        int choice = sc.nextInt();
        switch (choice) {
           case 1 -> {
               System.out.println("Enter fahrenheit");
               double fahrenheit = sc.nextDouble();
               double celsius = convertFahrenheitToCelsius(fahrenheit);
               System.out.println("The celsius is " + celsius);
           }
           case 2 -> {
               System.out.println("Enter celsius");
               double celsius = sc.nextDouble();
               double fahrenheit = convertCelsiusToFahrenheit(celsius);
               System.out.println("The fahrenheit is " + fahrenheit);
           }
            default -> System.out.println("Invalid choice. You`ve entered bullshit.");
        }

    }


    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - CONV_CELSIUS) * 5 / 9;
    }

    private static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + CONV_CELSIUS;
    }
}
