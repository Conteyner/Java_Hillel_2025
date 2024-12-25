package org.lessons.lesson_2;

import java.util.Scanner;

public class Main {
    private static final double CONV_D = 1.609344;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("This program converts miles to kilometers.");
        System.out.println("Please, enter miles");

        double miles = sc.nextDouble();
        double km = miles * CONV_D;
        System.out.println("Converted successfully - " + km + " km");

    }
}

