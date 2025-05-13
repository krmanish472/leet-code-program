package LeetCode.Easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] arr) {
        int leftIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) { // non-zero found => swap
                if (i != leftIdx) { // swap only if index is different
                    swap(arr, leftIdx, i);
                }
                leftIdx++; // increment to move left index
            }
        }
    }

    private static void swap(int[] arr, int leftIdx, int i) {
        int temp = arr[leftIdx];
        arr[leftIdx] = arr[i];
        arr[i] = temp;
    }
}
