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
            case 1: {
                System.out.println("Please, enter miles");
                double miles = sc.nextDouble();
                double km = miles * CONV_D;
                System.out.println("Converted successfully - " + km + " km");
                break;
            }
            case 2: {
                System.out.println("Please, enter kilometers");
                double km = sc.nextDouble();
                double miles = km / CONV_D;
                System.out.println("Converted successfully - " + miles + " miles");
                break;
            }
            default: {
                System.out.println("Invalid choice. You`ve entered bullshit. Try again.");
            }
        }
    }
}