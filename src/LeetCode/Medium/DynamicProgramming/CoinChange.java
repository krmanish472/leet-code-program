package LeetCode.Medium.DynamicProgramming;

import java.util.Arrays;

/*
* Given an integer array coins representing coins of different denominations and an integer amount representing a total amount
* Return the fewest number of coins that you need to make up that amount.
* If that amount of money cannot be made up by any combination of the coins, return -1.

* Example 1:
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

* Example 2:
    Input: coins = [2], amount = 3
    Output: -1

* Example 3:
    Input: coins = [1], amount = 0
    Output: 0
* */

// Dynamic Programming
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 9};
        int amount = 11;

        int numOfCoins = coinChange(coins, amount);
        System.out.println(numOfCoins);
    }

    public static int coinChange(int[] coins, int amount) {
        // for amt 11 => DP array of 0-11 is required i.e. size =12
        int[] amtDP = new int[amount + 1];

        Arrays.fill(amtDP, amount + 1);
        amtDP[0] = 0;

        for (int i = 1; i <= amount; i++) { // fill each index in DP array
            for (int coin : coins) {
                // we can only fill using coin if its equal or less than DP[index] e.g. DP[7] can only use 1, 5, 6 coins
                if (coin <= i) {
                    // 1 indicates the coin in action. For 7 => 5 (i.e. => 1) + 2 (i.e. => 7-5 => i-coin)
                    amtDP[i] = Math.min(amtDP[i], 1 + amtDP[i - coin]);
                }
            }
        }

        if (amtDP[amount] < amount + 1) {
            return amtDP[amount];
        } else {
            return -1;
        }
    }
}
