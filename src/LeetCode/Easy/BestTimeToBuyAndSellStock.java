package LeetCode.Easy;

/*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
* You want to maximize your profit by choosing a single day to buy one stock and
* choosing a different day in the future to sell that stock.
* Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0

* Ex:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
* */

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    static int maxProfit(int[] prices) {
        // at first, we must buy and can not sell
        int buyPrice = prices[0];

        // max profit is 0 until sold
        int profit = 0;

        // for each day, get the current day price and if it's less, buy
        // if it's more, sell
        for (int i = 1; i < prices.length; i++) {
            int currentDayPrice = prices[i];
            if (currentDayPrice < buyPrice) {
                buyPrice = prices[i];
            } else {
                profit = Math.max(profit, currentDayPrice - buyPrice);
            }
        }
        return profit;
    }
}
