package LeetCode.Medium;

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

* Ex:
    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Total profit is 4 + 3 = 7.
* */

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 9};
        int profit = maxProfit(prices);

        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // if price of next day is greater, profit can be booked
            if (prices[i + 1] > prices[i]) {
                totalProfit += prices[i + 1] - prices[i];
            }
        }
        return totalProfit;
    }
}
