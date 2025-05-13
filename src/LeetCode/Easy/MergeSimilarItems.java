package LeetCode.Easy;

/*
* You are given two 2D integer arrays, items1 and items2, representing two sets of items.
* Each array items has the following properties:
    items[i] = [valuei, weighti]
    where valuei represents the value and weighti represents the weight of the ith item.

* The value of each item in items is unique.

* Return a 2D integer array ret where ret[i] = [valuei, weighti],
* with weighti being the sum of weights of all items with value valuei.

* Note: ret should be returned in ascending order by value.

* Example 1:
    Input: items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
    Output: [[1,6],[3,9],[4,5]]
    Explanation:
    The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 5, total weight = 1 + 5 = 6.
    The item with value = 3 occurs in items1 with weight = 8 and in items2 with weight = 1, total weight = 8 + 1 = 9.
    The item with value = 4 occurs in items1 with weight = 5, total weight = 5.
    Therefore, we return [[1,6],[3,9],[4,5]].

* Example 2:
    Input: items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
    Output: [[1,4],[2,4],[3,4]]
    Explanation:
    The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 3, total weight = 1 + 3 = 4.
    The item with value = 2 occurs in items1 with weight = 3 and in items2 with weight = 1, total weight = 3 + 1 = 4.
    The item with value = 3 occurs in items1 with weight = 2 and in items2 with weight = 2, total weight = 2 + 2 = 4.
    Therefore, we return [[1,4],[2,4],[3,4]].

* */

import java.util.*;

public class MergeSimilarItems {
    public static void main(String[] args) {
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};

        List<List<Integer>> mergedItems = mergeSimilarItems(items1, items2);
        System.out.println(mergedItems);
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> mergedList = new ArrayList<>(); // [[1,6],[3,9],[4,5]]

        int[] weights = new int[1001]; // 1->6, 3->9, 4->5

        for (int[] arr : items1) {
            weights[arr[0]] = arr[1];
        }
        for (int[] arr : items2) {
            weights[arr[0]] = weights[arr[0]] + arr[1];
        }

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] != 0) {
                mergedList.add(List.of(i, weights[i]));
            }
        }

        return mergedList;
    }

    public static List<List<Integer>> mergeSimilarItems_usingMap(int[][] items1, int[][] items2) {
        List<List<Integer>> mergedItems = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>(); // used TreeMap

        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }

        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            mergedItems.add(Arrays.asList(e.getKey(), e.getValue()));
        }

        return mergedItems;
    }
}
