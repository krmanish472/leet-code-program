package LeetCode.Medium;

/*
* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
* Find two lines that together with the x-axis form a container, such that the container contains the most water.
* Return the maximum amount of water a container can store.
* Example:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
                 In this case, the max area of water (blue section) the container can contain is 49.
* */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int leftPtr = 0;
        int rightPtr = height.length - 1;

        while (leftPtr < rightPtr) {
            int w = rightPtr - leftPtr;
            int h = Math.min(height[leftPtr], height[rightPtr]);
            int area = w * h;

            max = Math.max(max, area);

            if (height[leftPtr] <= height[rightPtr]) {
                leftPtr++;
            } else {
                rightPtr--;
            }
        }
        return max;
    }
}
