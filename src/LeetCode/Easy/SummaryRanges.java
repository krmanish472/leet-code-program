package LeetCode.Easy;

/*
* You are given a sorted unique integer array nums.
* A range [a,b] is the set of all integers from a to b (inclusive).

* Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
* That is, each element of nums is covered by exactly one of the ranges, and there is no integer x
* such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:
    "a->b" if a != b
    "a" if a == b

* Example 1:
    Input: nums = [0,1,2,4,5,7]
    Output: ["0->2","4->5","7"]
    Explanation: The ranges are: // must have sequential elements
    [0,2] --> "0->2"
    [4,5] --> "4->5"
    [7,7] --> "7"

* Example 2:
    Input: nums = [0,2,3,4,6,8,9]
    Output: ["0","2->4","6","8->9"]
    Explanation: The ranges are:
    [0,0] --> "0"
    [2,4] --> "2->4"
    [6,6] --> "6"
    [8,9] --> "8->9"
* */

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int start = nums[i];
            // add bound of i+1 < n so that it stops the loop and does not keep checking for index out of bound
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            // if same just add that number
            if (start == nums[i]) {
                list.add("" + start);
            } else { // else add the range
                list.add(start + "->" + nums[i]);
            }
        }
        return list;
    }
}
