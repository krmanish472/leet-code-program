package LeetCode.Medium.DynamicProgramming;

/*
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.

 * Given the two integers m and n, return the number of possible unique paths that the robot can take
 * to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
 * */

// 2D version of climbing stairs
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;

        int noOfWays = uniquePaths(m, n);
        System.out.println(noOfWays);
    }

    public static int uniquePaths(int m, int n) {
        int[][] gridDP = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // for first row and first col => there is only 1 way
                if (i == 0 || j == 0) {
                    gridDP[i][j] = 1;
                } else {
                    // memoize the number of ways to reach that cell
                    gridDP[i][j] = gridDP[i - 1][j] + gridDP[i][j - 1];
                }
            }
        }

        return gridDP[m - 1][n - 1];
    }

    // Robot can reach the last grid by [i, j]
    // 1. going 1 step down from above col [i-1, j]
    // 2. going 1 step right from prev grid [i, j-1]
}
