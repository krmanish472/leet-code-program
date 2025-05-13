package LeetCode.Medium.DynamicProgramming;

/*
* You are given an integer array coins representing coins of different denominations and an integer amount
* representing a total amount of money.
* Return the number of combinations that make up that amount.
* If that amount of money cannot be made up by any combination of the coins, return 0.
* You may assume that you have an infinite number of each kind of coin.

* Example 1:
    Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1

Example 2:
    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
    Input: amount = 10, coins = [10]
    Output: 1
* */

// Dynamic Programming
public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 4;

        System.out.println(change(coins, amount));
    }

    public static int change(int[] coins, int amount) {
        int[] amtDP = new int[amount + 1];
        amtDP[0] = 1; // ways to make 0 is considered 1

        for (int coin : coins) {
            // fill the DP array from coin denomination to amount
            for (int i = coin; i <= amount; i++) {
                amtDP[i] += amtDP[i - coin]; // formula
            }
        }
        return amtDP[amount];
    }
}
