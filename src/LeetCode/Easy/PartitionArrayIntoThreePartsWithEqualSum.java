package LeetCode.Easy;

/*
* Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

* Formally, we can partition the array if we can find indexes i + 1 < j
with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

* Example 1:
    Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
    Output: true
    Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

* Example 2:
    Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
    Output: false
* */

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 0, 4};

        if (canThreePartsEqualSum(arr)) {
            System.out.println("Can Partition");
        } else {
            System.out.println("Can not Partition");
        }
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        // find total sum
        int totalSum = 0;
        for (int j : arr) {
            totalSum += j;
        }

        // check if total sum can be divided into 3 parts
        if (totalSum % 3 != 0) {
            return false;
        }

        int partitionCount = 0;

        int currSum = 0;
        for (int num : arr) {
            currSum += num;
            // if current sum is 1/3rd of total sum => partition is created
            if (currSum == totalSum / 3) {
                partitionCount++;
                // if we get 3 or more partitions, means we can divide in 3 equal parts
                if (partitionCount == 3) {
                    return true;
                }
                // reset current sum to 0 to start with next partition
                currSum = 0;
            }
        }
        return false;
    }
}
