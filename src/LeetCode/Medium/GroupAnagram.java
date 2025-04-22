package LeetCode.Medium;

/*
Given an array of strings strs, group the anagrams together
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/


import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagram(input));
    }

    static List<List<String>> groupAnagram(String[] arr) {
        if (arr.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        // array to count character frequency
        int[] charCount = new int[26];

        // for each string/word in array, fill with 0 and increase charCount from letter
        for (String str : arr) {
            Arrays.fill(charCount, 0);
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            // create key for HashMap
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(charCount[i]);
            }
            String key = stringBuilder.toString();

            // each anagram words will have unique key - if not unique, not an anagram!
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // keep adding anagrams to the list
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
