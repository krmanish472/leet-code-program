package LeetCode.Easy;

/*
* Given two arrays of strings list1 and list2, find the common strings with the least index sum.
* A common string is a string that appeared in both list1 and list2.
* A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j]
* then i + j should be the minimum value among all the other common strings.

* Return all the common strings with the least index sum. Return the answer in any order.

* Example 1:
    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
    Output: ["Shogun"]
    Explanation: The only common string is "Shogun".

* Example 2:
    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
    Output: ["Shogun"]
    Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.

* Example 3:
    Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
    Output: ["sad","happy"]
    Explanation: There are three common strings:
    "happy" with index sum = (0 + 1) = 1.
    "sad" with index sum = (1 + 0) = 1.
    "good" with index sum = (2 + 2) = 4.
    The strings with the least index sum are "sad" and "happy".
* */

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        String[] res = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(res));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minIndexSum = Integer.MAX_VALUE;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = i + map.get(list2[i]);

                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    // initially, any match will be > minIndexSum
                    // so create a new ArrayList everytime we encounter A NEW MIN
                    result = new ArrayList<>();
                    result.add(list2[i]);
                }
                // if more than one match has same count of min E.g. 1,1 we need to add both
                else if (indexSum == minIndexSum) {
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
