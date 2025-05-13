package DSA.SlidingWindow;

/*
 * Sliding Window problems involve moving a fixed or variable-size window through a data structure, typically an array or string
 * To solve problems efficiently based on continuous subsets of elements.
 * This technique is used when we need to find subarrays or substrings according to a given set of conditions.
 * */

public class ReturnMaxSumInSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        System.out.println(maxSum(arr, k));
        System.out.println(maxSum_using2Pointer(arr, k));

    }

    static int maxSum(int[] arr, int k) {
        int maxSum = 0;

        for (int i = 0; i < arr.length - (k - 1); i++) {
            int currSum = 0;
            for (int j = 0; j < k; j++) {
                currSum += arr[i + j];
            }

            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    static int maxSum_using2Pointer(int[] arr, int k) {
        // 1, 4, 2, 10, 2, 3, 1, 0, 20
        // 4

        int maxSum = 0;

        int low = 0;
        int high = 0;

        int currSum = 0;

        while (high < arr.length) {
            currSum += arr[high];
            high++;

            while (high - low > k) {
                currSum -= arr[low];
                low++;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
