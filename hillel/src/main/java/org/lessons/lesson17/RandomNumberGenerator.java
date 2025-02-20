package org.lessons.lesson17;

public class RandomNumberGenerator {

    static int generateRandomNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }

}
