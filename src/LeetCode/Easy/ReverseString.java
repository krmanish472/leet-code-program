package LeetCode.Easy;

/*
* Write a function that reverses a string. The input string is given as an array of characters s.
* You must do this by modifying the input array in-place with O(1) extra memory.

* Example 1:
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]

* Example 2:
    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]
* */

public class ReverseString {
    public static void main(String[] args) {

    }

    public static void reverseString(char[] s) {
        int leftPtr = 0;
        int rightPtr = s.length - 1;

        while (leftPtr <= rightPtr) {
            char temp = s[leftPtr];
            s[leftPtr] = s[rightPtr];
            s[rightPtr] = temp;

            leftPtr++;
            rightPtr--;
        }
    }
}
