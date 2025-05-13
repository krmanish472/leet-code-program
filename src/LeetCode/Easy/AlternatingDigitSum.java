package LeetCode.Easy;

/*
* You are given a positive integer n. Each digit of n has a sign according to the following rules:
    The most significant digit is assigned a positive sign.
    Each other digit has an opposite sign to its adjacent digits.

* Return the sum of all digits with their corresponding sign.

* Example 1:
    Input: n = 521
    Output: 4
    Explanation: (+5) + (-2) + (+1) = 4.

* */
public class AlternatingDigitSum {
    public static void main(String[] args) {
        int num = 521;

        int sum = alternateDigitSum(num);
        System.out.println(sum);
    }

    public static int alternateDigitSum(int n) {
        int sign = String.valueOf(n).length() % 2 == 0 ? -1 : 1;

        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * sign;
            n /= 10;
            sign *= -1; // if sign was 1 make it -1, if it was -1, make it +1
        }

        return sum;
    }
}
