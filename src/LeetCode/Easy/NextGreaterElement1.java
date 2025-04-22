package LeetCode.Easy;

/*
* The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
* You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
* For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

* Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

* Example 1:
    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    Output: [-1,3,-1]
    Explanation: The next greater element for each value of nums1 is as follows:
    - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
    - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
    - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

* Example 2:
    Input: nums1 = [2,4], nums2 = [1,2,3,4]
    Output: [3,-1]
    Explanation: The next greater element for each value of nums1 is as follows:
    - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
    - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};

        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));

        int[] res1 = nextGreaterElement_withStack(nums1, nums2);
        System.out.println(Arrays.toString(res1));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int idx = map.get(nums1[i]); // get starting index to loop from
            for (int j = idx; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                } else {
                    res[i] = -1;
                }
            }
        }

        return res;
    }


    public static int[] nextGreaterElement_withStack(int[] nums1, int[] nums2) { // [1,3,4,1,2]
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(nums2[nums2.length - 1]); // initially last element will be in stack
        map.put(nums2[nums2.length - 1], -1); // initially last index will be -1

        for (int i = nums2.length - 2; i >= 0; i--) {
            int currElement = nums2[i];

            // if top of stack is greater, it is next greatest
            if (stack.peek() > currElement) {
                map.put(currElement, stack.peek());
                stack.push(currElement);
                continue;
            }

            // remove all elements smaller than current element
            while (!stack.isEmpty() && stack.peek() < currElement) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(currElement);
                map.put(currElement, -1);
            } else {
                map.put(currElement, stack.peek());
                stack.push(currElement);
            }
        }

        // corresponding to each element in num1 =. fill the next increasing number
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }

}
