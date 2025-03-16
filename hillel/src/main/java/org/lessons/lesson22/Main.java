package org.lessons.lesson22;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import static org.lessons.lesson20.ArrayUtils.binarySearch;
import static org.lessons.lesson20.ArrayUtils.mergeSort;

public class Main {
    public static void main(String[] args) {
        Class<ArrayUtils> clazz = ArrayUtils.class;

        Random random = new Random();
        int size = 5;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Init Array:");
        System.out.println(Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(array));

        int target = array[random.nextInt(size)];
        System.out.println("Value: " + target);

        int index = binarySearch(array, target);
        if (index != -1) {
            System.out.println("Value " + target + " founded in " + index);
        } else {
            System.out.println("not found");
        }


        for(Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Author.class)) {
                System.out.println("Author" + method.getAnnotation( Author.class));
            }
            if (method.isAnnotationPresent(MethodInfo.class)) {
                System.out.println("Method info" + method.getAnnotation(MethodInfo.class));
            }
        }

    }
}