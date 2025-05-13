package LeetCode.Easy.PrefixSum;

/*
* Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

* A subarray is a contiguous subsequence of the array.

* Example 1:
    Input: arr = [1,4,2,5,3]
    Output: 58
    Explanation: The odd-length subarrays of arr and their sums are:
    [1] = 1
    [4] = 4
    [2] = 2
    [5] = 5
    [3] = 3
    [1,4,2] = 7
    [4,2,5] = 11
    [2,5,3] = 10
    [1,4,2,5,3] = 15
    If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

* Example 2:
    Input: arr = [1,2]
    Output: 3
    Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
* */

public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};

        int sum = sumOddLengthSubarrays(arr);
        System.out.println(sum);
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;

        // for odd length 1, sum is sum of all elements 1-by-1
        for (int el : arr) {
            totalSum += el;
        }

        int oddLength = 3; // start with next odd length i.e. => 3
        while (oddLength <= arr.length) {
            totalSum += sumSubarray(arr, oddLength);
            oddLength += 2; // next length is 5, 7, etc.
        }

        return totalSum;
    }

    public static int sumSubarray(int[] arr, int oddLength) { // 1, 4, 2, 5, 3
        int sum = 0;
        for (int i = 0; i < arr.length - (oddLength - 1); i++) { // oddLength - 1 for 0-based index

            /*
                int startIdx = i;
                int range = 0;
                while (range < oddLength) {
                    sum += arr[startIdx++];
                    range++;
                }
            */

            // loop through each index i and go till oddLength

            // E.g. for oddLength = 3
            // i = 0 => [1,4,2]
            // i = 1 => [4,2,5]
            // i = 2 => [2,5,3]

            // E.g. for oddLength = 5
            // i = 0 => [1,4,2,5,3]

            for (int j = i; j < i + oddLength; j++) {
                sum += arr[j];
            }
        }

        return sum;
    }
}
