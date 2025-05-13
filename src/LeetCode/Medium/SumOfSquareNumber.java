package LeetCode.Medium;

/*
* Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

* Example 1:
    Input: c = 5
    Output: true
    Explanation: 1 * 1 + 2 * 2 = 5

* Example 2:
    Input: c = 3
    Output: false
* */

public class SumOfSquareNumber {
    public static void main(String[] args) {
        int c = 5;

        if (judgeSquareSum(c)) {
            System.out.println("Sum of Square");
        } else {
            System.out.println("Not sum of square");
        }
    }

    public static boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (int) Math.sqrt(c);

        while (left < right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true;
            }

            if (sum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
