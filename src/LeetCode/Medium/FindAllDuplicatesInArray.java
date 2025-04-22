package LeetCode.Medium;

/*
* Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
* each integer appears at most twice, return an array of all the integers that appears twice.
* You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
* excluding the space needed to store the output

* Example 1:
    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [2,3]

* Example 2:
    Input: nums = [1,1,2]
    Output: [1]

* Example 3:
Input: nums = [1]
Output: []
* */

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> list = findDuplicates(nums);
        System.out.println(list);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // get index of corresponding element i.e. for element 4 at 0, index should be 3
            int index = Math.abs(nums[i]) - 1; // to get zero based index, -1 and abs to take +ve value and ignore the marked -ve

            if (nums[index] > 0) {
                // make element -ve to mark visited
                nums[index] = nums[index] * -1;
            } else { // if number is < 0 i.e. made -ve, it's a visited or a duplicate number
                result.add(index + 1);
            }
        }
        return result;
    }
}
