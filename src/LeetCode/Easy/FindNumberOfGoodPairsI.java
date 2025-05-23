package LeetCode.Easy;

/*
* You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively.
* You are also given a positive integer k.

* A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).

* Return the total number of good pairs.

* Example 1:
    Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1
    Output: 5
    Explanation:
    The 5 good pairs are (0, 0), (1, 0), (1, 1), (2, 0), and (2, 2).

* Example 2:
    Input: nums1 = [1,2,4,12], nums2 = [2,4], k = 3
    Output: 2
    Explanation:
    The 2 good pairs are (3, 0) and (3, 1).
* */
public class FindNumberOfGoodPairsI {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 12}, nums2 = {2, 4};
        int k = 3;

        // int[] nums1 = {1, 3, 4}, nums2 = {1, 3, 4};
        // int k = 1;

        int noOfPairs = numberOfPairs(nums1, nums2, k);
        System.out.println(noOfPairs); // 2 => (3, 0) and (3, 1)
    }

    // Note: to get indexes - avoid for loop and use index based for loop
    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int goodPairCount = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 % (num2 * k) == 0) {
                    goodPairCount++;
                }
            }
        }

        return goodPairCount;
    }
}
