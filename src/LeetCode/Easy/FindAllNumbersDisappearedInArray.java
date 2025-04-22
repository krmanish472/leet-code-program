package LeetCode.Easy;

/*
* Given an array nums of n integers where nums[i] is in the range [1, n],
* return an array of all the integers in the range [1, n] that do not appear in nums.

* Example 1:
    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [5,6]

* Example 2:
    Input: nums = [1,1]
    Output: [2]
* */

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = findDisappearedNumbers(nums);
        System.out.println(res);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // get index of corresponding element i.e. for element 4 at 0, index should be 3
            int index = Math.abs(nums[i]) - 1; // to get zero based index, -1 and abs to take +ve value and ignore the marked -ve

            if (nums[index] > 0) {
                // make element -ve to mark visited
                nums[index] = nums[index] * -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // check for non-visited numbers
                result.add(i + 1); // value will be index +1 as its zero based index
            }
        }
        return result;
    }
}
