package LeetCode.Medium;

/*
* Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

* Example 1:
    Input: x = 2.10000, n = 3
    Output: 9.26100

* Example 2:
    Input: x = 2.00000, n = -2
    Output: 0.25000
    Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
* */

public class PowXN {
    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;

        double res = myPow(x, n);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long N = n;

        // if N is negative, need to handle reciprocal of x
        if (N < 0) {
            x = 1 / x;
            N = -N; // make it +ve
        }

        double result = 1;
        double currentProduct = x;

        // exponential by squaring
        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // square the base
            N /= 2; // divide exponent by 2
        }
        return result;
    }
}
