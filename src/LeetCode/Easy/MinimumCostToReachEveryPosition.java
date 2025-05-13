package LeetCode.Easy;

import java.util.Arrays;

/*
* You are given an integer array cost of size n. You are currently at position n (at the end of the line) in a line of n + 1 people (numbered from 0 to n).
* You wish to move forward in the line, but each person in front of you charges a specific amount to swap places.
* The cost to swap with person i is given by cost[i].

* You are allowed to swap places with people as follows:
    If they are in front of you, you must pay them cost[i] to swap with them.
    If they are behind you, they can swap with you for free.

* Return an array answer of size n, where answer[i] is the minimum total cost to reach each position i in the line.

* Example 1:
    Input: cost = [5,3,4,1,3,2]
    Output: [5,3,3,1,1,1]
    Explanation:
    We can get to each position in the following way:
        i = 0. We can swap with person 0 for a cost of 5.
        i = 1. We can swap with person 1 for a cost of 3.
        i = 2. We can swap with person 1 for a cost of 3, then swap with person 2 for free.
        i = 3. We can swap with person 3 for a cost of 1.
        i = 4. We can swap with person 3 for a cost of 1, then swap with person 4 for free.
        i = 5. We can swap with person 3 for a cost of 1, then swap with person 5 for free.

* Example 2:
    Input: cost = [1,2,4,6,7]
    Output: [1,1,1,1,1]
    Explanation:
    We can swap with person 0 for a cost of 1, then we will be able to reach any position i for free.
* */

public class MinimumCostToReachEveryPosition {
    public static void main(String[] args) {
        int[] cost = {5, 3, 4, 1, 3, 2};

        int[] res = minCosts(cost);
        System.out.println(Arrays.toString(res));
    }

    // does not use extra memory
    public static int[] minCosts(int[] cost) {
        int minCost = cost[0]; // 5, 3, 1

        // first element remains as is... start with next element
        for (int i = 1; i < cost.length; i++) {
            // if cost to swap at i is less than min so far, swap using the cost at i
            // which means, no change in the element at i
            // just update the minCost
            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            // else if cost to swap at i is more than min so far, swap to min so far and move backwards
            // which means, element at i = minCost
            else {
                cost[i] = minCost;
            }

        }

        return cost;
    }

    public static int[] minCosts_basic(int[] cost) {
        int[] res = new int[cost.length];

        int minSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < cost.length; i++) {
            // E.g. for res[2]
            // either swap with cost[2] i.e. 4
            // or swap with cost[1] i.e. 3 and move backwards for free
            // min is cost[1] i.e. 3
            minSoFar = Math.min(minSoFar, cost[i]); // keep track of min before the current iteration
            res[i] = Math.min(minSoFar, cost[i]);
        }

        return res;
    }
}
