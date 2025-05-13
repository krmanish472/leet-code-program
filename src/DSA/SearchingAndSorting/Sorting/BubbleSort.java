package DSA.SearchingAndSorting.Sorting;

import java.util.Arrays;

/*
 * O(n2)
 * */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7, 12, 9, 11, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
