package LeetCode.Medium;

/*
* Given a collection of numbers, nums, that might contain duplicates,
* return all possible unique permutations in any order.

* Example 1:
    Input: nums = [1,1,2]
    Output:
    [[1,1,2], [1,2,1],[2,1,1]]

* Example 2:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
* */

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // [false, false, false] used flag for each elements
        boolean[] used = new boolean[nums.length];

        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length & !result.contains(current)) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;

                backtrack(result, current, nums, used);

                used[i] = false;
                current.removeLast();
            }
        }

    }
}
