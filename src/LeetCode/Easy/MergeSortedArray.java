package LeetCode.Easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // start from last index for both arrays
        int idx1 = m - 1;
        int idx2 = n - 1;

        int idx = nums1.length - 1; // index of resulting array

        while (idx2 >= 0) {
            if (idx1 >= 0 && nums1[idx1] > nums2[idx2]) {
                nums1[idx--] = nums1[idx1--];
            } else {
                nums1[idx--] = nums2[idx2--];
            }
        }
    }
}
