package LeetCode.Medium;

/*
* A triplet is an array of three integers. You are given a 2D integer array triplets, where triplets[i] = [ai, bi, ci]
* describes the ith triplet. You are also given an integer array target = [x, y, z] that describes the triplet you want to obtain.

* To obtain target, you may apply the following operation on triplets any number of times (possibly zero):
    Choose two indices (0-indexed) i and j (i != j) and update triplets[j] to become [max(ai, aj), max(bi, bj), max(ci, cj)].
    For example, if triplets[i] = [2, 5, 3] and triplets[j] = [1, 7, 5], triplets[j] will be updated to [max(2, 1), max(5, 7),
    max(3, 5)] = [2, 7, 5].

* Return true if it is possible to obtain the target triplet [x, y, z] as an element of triplets, or false otherwise.

* Example 1:
    Input: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
    Output: true

* Example 2:
    Input: triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
    Output: false
* */

// Greedy Approach
public class MergeTripletsToFormTargetTriplet {
    public static void main(String[] args) {
        int[][] triplets = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        if (mergeTriplets(triplets, new int[]{2,7,5})){
            System.out.println("Can merge");
        } else {
            System.out.println("Can not merge");
        }
    }

    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxValues = new int[3];

        for (int[] triplet : triplets) {
            // check if current triplet can contribute to target triplet
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                maxValues[0] = Math.max(maxValues[0], triplet[0]);
                maxValues[1] = Math.max(maxValues[1], triplet[1]);
                maxValues[2] = Math.max(maxValues[2], triplet[2]);
            }
        }

        // return Arrays.equals(maxValues, target);
        return maxValues[0] == target[0] && maxValues[1] == target[1] && maxValues[2] == target[2];
    }
}
