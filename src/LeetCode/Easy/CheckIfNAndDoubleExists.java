package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

/*
* Given an array arr of integers, check if there exist two indices i and j such that :
    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]

* Example 1:
    Input: arr = [10,2,5,3]
    Output: true
    Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

* Example 2:
    Input: arr = [3,1,7,11]
    Output: false
    Explanation: There is no i and j that satisfy the conditions.
* */
public class CheckIfNAndDoubleExists {
    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        if (checkIfExist(arr)){
            System.out.println("N and Double exists");
        } else {
            System.out.println("N and Double does not exists");
        }
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            // for a given number, check if double of the number exists
            // for a given number, check if half of the number exists in scenario like -> [7,1,14,11]
            if (set.contains(num * 2) ||
                    (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
