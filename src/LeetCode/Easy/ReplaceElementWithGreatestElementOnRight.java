package LeetCode.Easy;

import java.util.Arrays;

/*
* Given an array arr, replace every element in that array with the greatest element among the elements to its right,
* and replace the last element with -1.
* After doing so, return the array.

* Example 1:
    Input: arr = [17,18,5,4,6,1]
    Output: [18,6,6,6,1,-1]
    Explanation:
    - index 0 --> the greatest element to the right of index 0 is index 1 (18).
    - index 1 --> the greatest element to the right of index 1 is index 4 (6).
    - index 2 --> the greatest element to the right of index 2 is index 4 (6).
    - index 3 --> the greatest element to the right of index 3 is index 4 (6).
    - index 4 --> the greatest element to the right of index 4 is index 5 (1).
    - index 5 --> there are no elements to the right of index 5, so we put -1.

* Example 2:
    Input: arr = [400]
    Output: [-1]
    Explanation: There are no elements to the right of index 0.

* */

// Note: when we iterate from last index and we have Max(6,1) as 6
// -- no need to check for Max(4, 6, 1) we can just check (4, 6)
// similarly, if we know Max(18, 5, 4, 6, 1) is 18 then Max(17, 18, 5, 4, 6, 1) is Max(17, 18)
public class ReplaceElementWithGreatestElementOnRight {
    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};

        int[] res = replaceElements(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] replaceElements(int[] arr) {
        if (arr.length - 1 == 0) {
            arr[0] = -1;
            return arr;
        }

        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }

        return arr;
    }

    public static int[] replaceElements_basic(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = findMax_basic(arr, i + 1);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static int findMax_basic(int[] arr, int idx) {
        int max = Integer.MIN_VALUE;
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMax_usingMathFn(int[] arr, int idx) {
        int max = Integer.MIN_VALUE;
        for (int i = idx; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
