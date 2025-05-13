package LeetCode.Medium.SlidingWindow;
/*
* You are visiting a farm that has a single row of fruit trees arranged from left to right.
* The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
* You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
    You only have two baskets, and each basket can only hold a single type of fruit.
    There is no limit on the amount of fruit each basket can hold.
    Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
    * while moving to the right. The picked fruits must fit in one of your baskets.
    Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

* Given the integer array fruits, return the maximum number of fruits you can pick.

* Example 1:
    Input: fruits = [1,2,1]
    Output: 3
    Explanation: We can pick from all 3 trees.

* Example 2:
    Input: fruits = [0,1,2,2]
    Output: 3
    Explanation: We can pick from trees [1,2,2].
    If we had started at the first tree, we would only pick from trees [0,1].

* Example 3:
    Input: fruits = [1,2,3,2,2]
    Output: 4
    Explanation: We can pick from trees [2,3,2,2].
    If we had started at the first tree, we would only pick from trees [1,2].
* */

// Summary : find the length of the longest contiguous subarray with at most 2 distinct integer

import java.util.HashMap;
import java.util.Map;

// Sliding Window
public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 1, 3, 4, 2, 2, 2, 2, 4};

        int maxFruitCount = totalFruit(fruits);
        System.out.println(maxFruitCount);
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();

        int maxFruit = 0;

        int leftPtr = 0;
        for (int rightPtr = 0; rightPtr < fruits.length; rightPtr++) {
            basket.put(fruits[rightPtr], basket.getOrDefault(fruits[rightPtr], 0) + 1);

            // if basket has more than 2 fruits type, start removing fruits one-by-one, until...
            while (basket.size() > 2) {
                int fruitCount = basket.get(fruits[leftPtr]);
                // ... fruit count is 1 => then remove it
                if (fruitCount == 1) {
                    basket.remove(fruits[leftPtr]);
                } else {
                    basket.put(fruits[leftPtr], fruitCount - 1);
                }
                leftPtr++;
            }

            maxFruit = Math.max(maxFruit, rightPtr - leftPtr + 1);
        }

        return maxFruit;
    }
}
