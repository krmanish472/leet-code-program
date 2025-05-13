package DSA.SearchingAndSorting.Sorting;

import java.util.Arrays;

/*
 * select a element
 * walk backward from that element and if any element is greater than it shift right
 * O(n2)
 * */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 8, 6, 2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 1st element is assumed sorted
            int curr = arr[i];
            // start with element before current element until it reaches start of array
            int j = i - 1;
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }
}
