package org.lessons.lesson18;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("CPU", "Electronics", 4440.90),
                new Product("Coffee Maker", "Appliances", 900.0),
                new Product("GPU", "Electronics", 9050.0),
                new Product("Shitpost Machine", "Appliances", 1487.90)
        );

        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        System.out.println("Avg price per category: " + result);

        String categoryWithMaxAvg = result.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("you provided shit bro");
        System.out.println("Category with highest avg price: " + categoryWithMaxAvg);


    }
}
