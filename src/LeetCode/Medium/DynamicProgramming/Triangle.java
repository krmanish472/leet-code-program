package LeetCode.Medium.DynamicProgramming;

/*
* Given a triangle array, return the minimum path sum from top to bottom.
* For each step, you may move to an adjacent number of the row below.
* More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

* Example 1:
    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
       2
      3 4
     6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

* Example 2:
    Input: triangle = [[-10]]
    Output: -10
* */

import java.util.Arrays;
import java.util.List;

// Dynamic Programming
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(1, 3),
                Arrays.asList(8, 9, 1),
                Arrays.asList(4, 1, 8, 3)
        );

        int minTotal = minimumTotal(triangle);
        System.out.println(minTotal);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height + 1][height + 1];

        // track levels
        for (int level = height - 1; level >= 0; level--) {
            // track element in each level i.e. level 4 has 4 elements - index 3
            for (int i = 0; i <= level; i++) {
                dp[level][i] = triangle.get(level).get(i) + // get element
                        Math.min(dp[level + 1][i], dp[level + 1][i + 1]); // get min of adjacent elements

            }
        }

        return dp[0][0]; // in bottom-up approach, 1st element will have the result
    }
}
