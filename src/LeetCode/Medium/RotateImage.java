package LeetCode.Medium;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        rotate(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] rotate2(int[][] matrix) {
        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }

        return matrix;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // 4 ways swaps
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {

                // temp = bottom left
                int temp = matrix[n - 1 - j][i];

                //bottom left = bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // bottom right = top right
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                // top right = top left
                matrix[j][n - 1 - i] = matrix[i][j];

                // top left = temp
                matrix[i][j] = temp;
            }
        }
    }
}
