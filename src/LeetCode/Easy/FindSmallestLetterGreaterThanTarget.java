package LeetCode.Easy;

/*
* You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
* There are at least two different characters in letters.

* Return the smallest character in letters that is lexicographically greater than target.
* If such a character does not exist, return the first character in letters.


* Example 1:
    Input: letters = ["c","f","j"], target = "a"
    Output: "c"
    Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

* Example 2:
    Input: letters = ["c","f","j"], target = "c"
    Output: "f"
    Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

* Example 3:
    Input: letters = ["x","x","y","y"], target = "z"
    Output: "x"
    Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
* */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'd', 'e', 'f', 'j'};
        char target = 'e';
        char nextGreaterEl = nextGreatestLetter(letters, target);
        System.out.println(nextGreaterEl);

        char[] letters1 = new char[]{'x', 'x', 'y', 'y'};
        char target1 = 'y';

        char nextGreaterEl1 = nextGreatestLetter(letters1, target1);
        System.out.println(nextGreaterEl1);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (letters[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // if low pointer is out of bound - return letters[0]
        if (low < letters.length) {
            return letters[low];
        } else {
            return letters[0];
        }
    }
}
