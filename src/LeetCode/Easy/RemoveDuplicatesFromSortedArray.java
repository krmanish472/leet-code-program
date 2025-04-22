package LeetCode.Easy;

/*
* Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each
* unique element appears only once. The relative order of the elements should be kept the same.

* Then return the number of unique elements in nums.

* Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    Change the array nums such that the first k elements of nums contain the unique elements in the order they were
    present in nums initially. The remaining elements of nums are not important as well as the size of nums.

// Input [1,1,2] => Output [1,2]

* */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

        int size = removeDuplicates(arr);
        System.out.println(size);
    }

    static int removeDuplicates(int[] nums) {
        int count = 0;
        // for each element, loop through and check if it equals to other elements
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[count] = nums[i];
            count++;

        }
        return count;
    }
}
