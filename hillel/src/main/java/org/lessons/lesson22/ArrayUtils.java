package org.lessons.lesson22;


public class ArrayUtils {
    @MethodInfo(name = "mergeSort", returnType = "void", description = "This method of merge sorting")
    @Author(firstName = "Vadim", lastName = "Portnov")
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int length = arr.length;
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        int i = 0; // left
        int j = 0; // right
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }

    }

    @MethodInfo(name = "binarySearch", returnType = "int", description = "uses a binary search")
    @Author(firstName = "Vadim", lastName = "Portnov")
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;

    }


}
