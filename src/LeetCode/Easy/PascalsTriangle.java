package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

// [1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = generate(5);
        System.out.println(pascalTriangle);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // first row is always [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        triangle.add(firstRow);

        // for other rows => Loop from 1 to numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // first row is always 1
            row.add(1);

            // in between =>
            List<Integer> prevRow = triangle.get(i - 1);
            for (int index = 1; index < i; index++) { // index starts from 1 as 0 is already filled with [1]
                row.add(prevRow.get(index - 1) + prevRow.get(index));
            }

            // last row is always 1
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
