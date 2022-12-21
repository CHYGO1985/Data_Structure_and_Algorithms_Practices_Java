package src.TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 76. Minimum Window Substring
 * 
 * @author jingjiejang
 * @history Apr 29, 2021
 * 
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        
        assert s != null && t != null;

        // first build hashmap with count of distinct chars in t
        // use two pointers to build a sliding windows that contains all chars in t
        // move left until it cannot be form string t (by checking if count dis chars current windows == dif chars in t)
        // then expand right pointer again until can form string t
        // repeat 3 and 4

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> charCntInT = new HashMap<>();
        
        for (int idx = 0; idx < t.length(); idx ++) {
            char curChar = t.charAt(idx);
            charCntInT.put(curChar, charCntInT.getOrDefault(curChar, 0) + 1);
        }   

        int uniCharInT = charCntInT.size();

        int left = 0;
        // chars that match appearance frequency as string t
        int charMatch = 0;

        // 0: min string len, 1: min string left idx, 2: min string right idx
        int[] res = new int[]{-1, 0, 0};

        // hash map for cur windows char counts
        Map<Character, Integer> curWinCharCntMap = new HashMap<>();

        for (int right = 0; right < s.length(); right ++) {

            char curChar = s.charAt(right);
            curWinCharCntMap.put(curChar, curWinCharCntMap.getOrDefault(curChar, 0) + 1);

            if (charCntInT.containsKey(curChar) 
                // ** should use intValue, otherwise it will generate faults 
                && (curWinCharCntMap.get(curChar).intValue() == charCntInT.get(curChar).intValue())) {
                    charMatch ++;
                }

            while (left <= right && charMatch == uniCharInT) {

                // move left char until charMath != uniCharInT
                // update res[] array
                // update curWinCharCntMap

                char charInWin = s.charAt(left);

                if (res[0] == -1 || right - left + 1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }

                curWinCharCntMap.put(charInWin, curWinCharCntMap.get(charInWin) - 1);

                if (charCntInT.containsKey(charInWin) &&
                    (curWinCharCntMap.get(charInWin).intValue() < charCntInT.get(charInWin).intValue())) {

                        charMatch --;        
                }

                left ++;
            }
        }

        return res[0] == - 1 ? "" : s.substring(res[1], res[2] + 1);
    }
}
