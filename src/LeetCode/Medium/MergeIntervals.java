package LeetCode.Medium;

/*
* Given an array of intervals where intervals[i] = [starti, endi],
* merge all overlapping intervals,
* and return an array of the non-overlapping intervals that cover all the intervals in the input.
* Ex:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        for (int[] mergedInterval : mergedIntervals) {
            System.out.println(Arrays.toString(mergedInterval));
        }
    }

    private static int[][] merge(int[][] intervals) {
        List<int[]> mergedList = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort intervals in asc order

        for (int i = 0; i < intervals.length; i++) {
            int currMin = intervals[i][0]; // X
            int currMax = intervals[i][1]; // Y

            // merge only if currMax > nextMin
            while (i + 1 < intervals.length && currMax >= intervals[i + 1][0]) {
                currMax = Math.max(currMax, intervals[i + 1][1]);
                i++;
            }
            mergedList.add(new int[]{currMin, currMax});
        }
        return mergedList.toArray(new int[0][]);
    }
}
