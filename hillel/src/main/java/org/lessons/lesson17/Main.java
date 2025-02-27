package org.lessons.lesson17;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // MathOperation mathOperation = Integer::sum;
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a+b;
            }
        };


        StringManipulator toUpperCase = String::toUpperCase;
        Function<String, Integer> uppercaseCounter = StringListProcessor::countUppercase;
        Supplier<Integer> randNum = () -> RandomNumberGenerator.generateRandomNumber(1, 100);


        System.out.println("Summary: " + mathOperation.operate(1487,3));
        System.out.println("Uppercase count: " + uppercaseCounter.apply("NiСK, dO yOU plAy dOta?"));
        System.out.println("Random number is: " + randNum.get());
        System.out.println("Uppercased string: " + toUpperCase.manipulate("hello world"));

    }
}
