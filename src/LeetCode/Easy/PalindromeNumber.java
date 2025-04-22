package LeetCode.Easy;

/*
* Given an integer x, return true if x is a palindrome, and false otherwise.
* Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.

* Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

* Example 3:
    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
* */

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        if (isPalindrome(x)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }

    public static boolean isPalindrome(int n) {
        int original = n;
        int reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n = n / 10;
        }
        return reverse == original;
    }


}
