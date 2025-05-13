package LeetCode.Medium.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
* represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
* You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

* Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
* intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

* Example 1:
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

* Example 2:
    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
* */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};

        int[][] res = insert(intervals2, newInterval2);

        for (int[] mergedInterval : res) {
            System.out.println(Arrays.toString(mergedInterval));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // new intervals will have length +1 of existing length of intervals
        int[][] newIntervals = new int[intervals.length + 1][2];

        // copy existing intervals
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        // add new interval at the last of intervals
        newIntervals[intervals.length] = newInterval;

        // merge the intervals as usual...
        return merge(newIntervals);
    }

    public static int[][] merge(int[][] intervals) {
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

    public int[][] insert_anotherWay(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);

        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
