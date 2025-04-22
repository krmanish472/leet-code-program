package LeetCode.Medium;

/*
 * You are given an m x n integer matrix matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true
 * */

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 60};

        int target = 3;
        if (searchMatrix(matrix, target)){
            System.out.println("Value present");
        } else {
            System.out.println("Value not present");
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int leftPtr = 0;
        int rightPtr = m * n - 1;

        while (leftPtr <= rightPtr) {
            int mid = leftPtr + (rightPtr - leftPtr) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                leftPtr = mid + 1;
            } else {
                rightPtr = mid - 1;
            }
        }
        return false;
    }
}
