package LeetCode.Easy;

/*
* Given a signed 32-bit integer x, return x with its digits reversed.
* If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
* Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

* Example 1:
    Input: x = 123
    Output: 321

* Example 2:
    Input: x = -123
    Output: -321

* Example 3:
    Input: x = 120
    Output: 21
* */

public class ReverseInteger {
    public static void main(String[] args) {
        int num = 123;

        int reverseNum = reverse(num);
        System.out.println(reverseNum);
    }

    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int lastDigit = num % 10;
            rev = rev * 10 + lastDigit;
            num = num / 10;
        }
        return rev;
    }
}
