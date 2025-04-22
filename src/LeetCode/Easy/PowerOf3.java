package LeetCode.Easy;

/*
* Given an integer n, return true if it is a power of three. Otherwise, return false.
* An integer n is a power of three, if there exists an integer x such that n == 3x.

* Example 1:
    Input: n = 27
    Output: true
    Explanation: 27 = 3^3

* Example 2:
    Input: n = 0
    Output: false
    Explanation: There is no x where 3^x = 0.

* Example 3:
    Input: n = -1
    Output: false
    Explanation: There is no x where 3^x = (-1).
* */

public class PowerOf3 {
    public static void main(String[] args) {
        int n = 18;
        if (isPowerOfThree(n)) {
            System.out.println("Power of 3");
        } else {
            System.out.println("Not power of 3");
        }
    }

    public static boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return n == 1;

        // ... OR ... //
        /**
         while (n != 1) {
         if (n % 3 != 0) {
         return false;
         }
         n = n / 3;
         }
         return true;
         **/
    }
}
