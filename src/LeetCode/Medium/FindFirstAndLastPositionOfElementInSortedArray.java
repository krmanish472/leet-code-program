package LeetCode.Medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 5, 5, 7, 7, 7, 8, 8, 10,};
        int target = 7;

        int[] pos = searchRange(nums, target);
        System.out.println(Arrays.toString(pos));
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = findLeftIdx(nums, target);
        int rightIdx = findRightIdx(nums, target);

        return new int[]{leftIdx, rightIdx};
    }

    static int findLeftIdx(int[] nums, int target) {
        int index = -1;
        int low = 0;

        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if target is found - re check if it's really the start index
            if (nums[mid] == target) {
                index = mid;
                high = mid - 1; // look in left sub array
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }

    static int findRightIdx(int[] nums, int target) {
        int index = -1;
        int low = 0;

        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if target is found - re check if it's really the end index
            if (nums[mid] == target) {
                index = mid;
                low = mid + 1; // look in right sub-array
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }
}
