package LeetCode.Easy;

/*
* Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
* Return the kth positive integer that is missing from this array.

* Example 1:
    Input: arr = [2,3,4,7,11], k = 5
    Output: 9
    Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

* Example 2:
    Input: arr = [1,2,3,4], k = 2
    Output: 6
    Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
* */

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        int kthMissingNum = findKthPositive(arr, k);
        System.out.println(kthMissingNum);
    }

    public static int findKthPositive(int[] arr, int k) {
        int left = 0;
        // to get the mid value, we are actually looking at the number of elements, and not the index
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            // if number of missing element is less than k
            int currentNum = arr[mid];
            int actualNum = mid + 1; // index +1

            if (currentNum - actualNum < k) {
                left = mid + 1; // keep moving towards right
            } else {
                right = mid;
            }
        }
        // 5th missing + index
        return left + k;
    }
}
