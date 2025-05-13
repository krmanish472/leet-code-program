package DSA.SearchingAndSorting.Sorting;

/*
 * Select a pivot
 * move all nums lower than pivot to left and all nums higher than pivot to right => partitioning
 * create left right pointer => left: if el is larger than pivot, right: if el is smaller than pivot
 * swap elements at left right position
 * if left right are at same, swap pivot with left/right pointer
 * recursively quick sort for left and right partition
 * O(nlogn)
 * */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 9, 4, 5, 7};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int lowIdx, int highIdx) {
        if (lowIdx >= highIdx) { // sub array of just 1 element
            return;
        }

        int pivot = arr[highIdx];

        int leftPtr = lowIdx;
        int rightPtr = highIdx;

        while (leftPtr < rightPtr) {
            while (arr[leftPtr] <= pivot && leftPtr < rightPtr) { // keep searching for element greater than pivot
                leftPtr++;
            }
            while (arr[rightPtr] >= pivot && leftPtr < rightPtr) { // keep searching for element less than pivot
                rightPtr--;
            }
            swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, highIdx); // swap pivot with left index value

        quicksort(arr, lowIdx, leftPtr - 1); // quick sort left partition
        quicksort(arr, leftPtr + 1, highIdx); // quick sort right partition
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
