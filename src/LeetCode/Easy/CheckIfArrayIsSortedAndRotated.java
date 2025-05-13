package LeetCode.Easy;

/*
* Given an array nums, return true if the array was originally sorted in non-decreasing order,
* then rotated some number of positions (including zero). Otherwise, return false.

* There may be duplicates in the original array.

* Note: An array A rotated by x positions results in an array B of the same length
* such that B[i] == A[(i+x) % A.length] for every valid index i.

* Example 1:
    Input: nums = [3,4,5,1,2]
    Output: true
    Explanation: [1,2,3,4,5] is the original sorted array.
    You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].

* Example 2:
    Input: nums = [2,1,3,4]
    Output: false
    Explanation: There is no sorted array once rotated that can make nums.
* */
public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4};

        if (check(nums)) {
            System.out.println("Sorted Rotated");
        } else {
            System.out.println("Not Sorted Rotated");
        }
    }

    public static boolean check(int[] nums) {
        int breakCount = 0;

        for (int i = 1; i < nums.length; i++) {
            // there should be exactly 1 element that is less than it's previous element
            if (nums[i] < nums[i - 1]) {
                breakCount++;
            }
            // if greater than 1 then we cannot rotate the array into sorted form
            if (breakCount > 1) {
                return false;
            }
        }

        if (nums[nums.length - 1] > nums[0]) { // [2,1,3,4]
            breakCount++;
        }

        return breakCount <= 1;
    }

    public static boolean check_alt(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        // check for 1st ascending curve - curr element should be > prev element
        int idx = 1;
        while (idx < n && nums[idx] >= nums[idx - 1]) {
            idx++;
        }
        // edge case - if entire array is still ascending
        if (idx == n) {
            return true;
        }


        // start of new curve should be less than 1st element
        if (nums[idx] > nums[0]) {
            return false;
        }
        // check the 2nd ascending curve - curr element should be > prev element
        idx++;
        while (idx < n && nums[idx] >= nums[idx - 1] && nums[idx] <= nums[0]) {
            idx++;
        }

        return idx == n;
    }
}
