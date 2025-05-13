package LeetCode.Easy;

/*
* You are given two arrays of equal length, nums1 and nums2.
* Each element in nums1 has been increased (or decreased in the case of negative) by an integer,
* represented by the variable x.

* As a result, nums1 becomes equal to nums2. Two arrays are considered equal when they contain the same integers
* with the same frequencies.

* Return the integer x.

* Example 1:
    Input: nums1 = [2,6,4], nums2 = [9,7,5]
    Output: 3
    Explanation:
    The integer added to each element of nums1 is 3.

* Example 2:
    Input: nums1 = [10], nums2 = [5]
    Output: -5
    Explanation:
    The integer added to each element of nums1 is -5.
* */

import java.util.Arrays;

public class FindIntegerAddedToArrayI {
    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4}, nums2 = {9, 7, 5};

        int numAdded = addedInteger(nums1, nums2);
        System.out.println(numAdded);
    }

    public static int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return nums2[0] - nums1[0];
    }

    public int addedInteger_usingMathFormula(int[] nums1, int[] nums2) {
        int sumOfElementInArr1 = 0;
        int sumOfElementInArr2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            sumOfElementInArr1 += nums1[i];
            sumOfElementInArr2 += nums2[i];
        }

        return (sumOfElementInArr2 - sumOfElementInArr1) / nums1.length;
    }

    public static int addedInteger_withoutSorting(int[] nums1, int[] nums2) {
        int minInFirstArr = Integer.MAX_VALUE;
        int minInSecondArr = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            minInFirstArr = Math.min(minInFirstArr, nums1[i]); // get min element in first array
            minInSecondArr = Math.min(minInSecondArr, nums2[i]); // get min element in second array
        }

        return minInSecondArr - minInFirstArr;
    }
}
