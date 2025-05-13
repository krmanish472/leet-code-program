package LeetCode.Easy.TwoPointer;

/*
* Given an array of meeting intervals where interval[i] = [start, end]
* Determine if a person could attend all the meetings
* Example:
    intervals = [[0,30], [5,10], [15, 20]] => false
    intervals = [[7,10], [2,4]] => true
* */

import java.util.Arrays;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        int[][] arr2 = {{7,10}, {2,7}};
        if(canAttendMeetings(arr2)){
            System.out.println("Can attend meeting!");
        } else {
            System.out.println("Can't attend meeting!");
        }
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
