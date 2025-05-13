package LeetCode.Easy;

/*
* Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.
* The digit sum of a positive integer is the sum of all its digits.

* Example 1:
    Input: num = 4
    Output: 2
    Explanation:
    The only integers less than or equal to 4 whose digit sums are even are 2 and 4.


* Example 2:
    Input: num = 30
    Output: 14
    Explanation:
    The 14 integers less than or equal to 30 whose digit sums are even are
    2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
* */
public class CountIntegerWithEvenDigitSum {
    public static void main(String[] args) {
        int count = countEven(30);
        System.out.println(count);
    }

    public static int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (sumOfDigit(i) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    private static int sumOfDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
