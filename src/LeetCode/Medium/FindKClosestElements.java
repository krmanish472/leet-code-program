package LeetCode.Medium;

/*
* Given a sorted integer array arr, two integers k and x,

* return the k closest integers to x in the array.

* The result should also be sorted in ascending order.

* An integer a is closer to x than an integer b if:
    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b

Example 1:
    Input: arr = [1,2,3,4,5], k = 4, x = 3
    Output: [1,2,3,4]

Example 2:
    Input: arr = [1,1,2,3,4,5], k = 4, x = -1
    Output: [1,1,2,3]

* */

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int k = 4, x = 3;

        List<Integer> list = findClosestElements(arr, k, x);
        System.out.println(list);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        // array is sorted hence to get the closest k numbers i.e. sliding window of k
        // use 2 Pts to either move the pointer to left or right
        // E.g. for K = 4, this while loop will run to get the window of size 4 [0-3]
        // where 0 is the left Ptr and 3 is the right Ptr

        // keep updating left and right pointer until the window size becomes k
        while (right - left != k - 1) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
