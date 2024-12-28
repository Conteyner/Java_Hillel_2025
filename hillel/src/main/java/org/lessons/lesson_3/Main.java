package org.lessons.lesson_3;

import java.util.Scanner;

public class Main {
    private static final double CONV_CELSIUS = 32; //constant for the formula

    public static void main(String[] args) {
        System.out.println("This program converts fahrenheit to celsius.");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fahrenheit: ");

        double fahrenheit = sc.nextDouble();
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println("The celsius is " + celsius);

    }

    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - CONV_CELSIUS) * 5 / 9; //
    }
}
