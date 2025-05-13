package LeetCode.Easy;

/*
* Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

* Note that elements beyond the length of the original array are not written.
* Do the above modifications to the input array in place and do not return anything.

* Example 1:
    Input: arr = [1,0,2,3,0,4,5,0]
    Output: [1,0,0,2,3,0,0,4]
    Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

* Example 2:
    Input: arr = [1,2,3]
    Output: [1,2,3]
    Explanation: After calling your function, the input array is modified to: [1,2,3]
* */
public class DuplicateZeros {
    public static void main(String[] args) {

    }

    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        for (int el : arr) {
            if (el == 0) {
                zeros++;
            }
        }

        int i = arr.length - 1;
        int j = arr.length - 1 + zeros; // imaginary index with duplicated zeros

        while (i < j) {
            replace(arr, i, j--);
            if (arr[i] == 0) {
                replace(arr, i, j--);
            }
            i--;
        }

    }

    private static void replace(int[] arr, int i, int j) {
        // should be replaced only if j is within the array range
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }
}
