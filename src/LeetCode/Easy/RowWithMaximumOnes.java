package LeetCode.Easy;

import java.util.Arrays;
import java.util.Map;

/*
* Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones,
* and the number of ones in that row.

* In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.

* Return an array containing the index of the row, and the number of ones in it.

* Example 1:
    Input: mat = [[0,1],[1,0]]
    Output: [0,1]
    Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0, and the maximum count of ones (1). So, the answer is [0,1].

* Example 2:
    Input: mat = [[0,0,0],[0,1,1]]
    Output: [1,2]
    Explanation: The row indexed 1 has the maximum count of ones (2). So we return its index, 1, and the count. So, the answer is [1,2].

* Example 3:
    Input: mat = [[0,0],[1,1],[0,0]]
    Output: [1,2]
    Explanation: The row indexed 1 has the maximum count of ones (2). So the answer is [1,2].
* */
public class RowWithMaximumOnes {
    public static void main(String[] args) {
        int[][] mat = {{0, 1}, {1, 1}, {0, 0}};
        int[][] mat1 = {{0, 1}, {1, 0}};

        int[] res = rowAndMaximumOnes(mat);
        System.out.println(Arrays.toString(res));

        int[] res1 = rowAndMaximumOnes(mat1);
        System.out.println(Arrays.toString(res1));
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2]; // [row-index, maxOnesCount]

        for (int i = 0; i < mat.length; i++) {
            int currOneCount = 0;
            for (int el : mat[i]) {
                // we can check if element is 1 and increase the count by 1
                // OR we can simply add all elements in array as its just 0 and 1 and sum gives count of 1
                currOneCount += el;
            }
            // we can create separate variable as maxOnesCount and check if currOneCount > maxOnesCount
            // Then, update maxOnesCount in the condition => maxOnesCount = currOneCount; AND maxOnesIndex = i;
            // OR simply use res array {0, 0} as the 2 variables => res[0] as maxOnesIndex | res[1] as maxOnesCount
            if (currOneCount > res[1]) {
                res[0] = i;
                res[1] = currOneCount;
            }
        }

        return res;
    }
}
