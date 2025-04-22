package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

/*
* A happy number is a number defined by the following process:
* Starting with any positive integer, replace the number by the sum of the squares of its digits.
* Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
* Those numbers for which this process ends in 1 are happy.

* Return true if n is a happy number, and false if not.

* Example 1:
    Input: n = 19
    Output: true
    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
* */
public class HappyNumber {
    public static void main(String[] args) {
        if (isHappy(19)){
            System.out.println("Happy Number");
        } else {
            System.out.println("Not Happy Number");
        }
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }

    private static int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }
}
