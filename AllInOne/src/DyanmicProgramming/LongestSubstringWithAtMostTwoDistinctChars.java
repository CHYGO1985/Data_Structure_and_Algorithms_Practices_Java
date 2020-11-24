import java.util.HashMap;

/**
 * 
 * 159. Longest Substring with At Most Two Distinct Characters
 * 
 * @CHYGO1985
 * @history Nov 24, 2020
 * 
 * ref: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 * 
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        if (s == null || s.length() == 0) return 0;

        int maxLen = 0, charCount = 0, sLen = s.length();
        Map<Character, Integer> charCntMap = new HashMap<>();
        char[] charsInS = s.toCharArray();

        // idx of end and front 
        int endIdx = 0, beginIdx = 0;

        while (endIdx < sLen) {

            int curCharCnt = charCntMap.getOrDefault(charsInS[endIdx], 0);
            if (curCharCnt == 0) {
                charCount ++;
            }

            charCntMap.put(charsInS[endIdx], curCharCnt + 1);
            endIdx ++;

            while (charCount > 2) {

                int tmpCharCnt = charCntMap.getOrDefault(charsInS[beginIdx], 0) - 1;
                if (tmpCharCnt == 0) {
                    charCount --;
                }
                charCntMap.put(charsInS[beginIdx], tmpCharCnt);
                beginIdx ++;
            }

            maxLen = Math.max(maxLen, endIdx - beginIdx);
        }

        return maxLen;
    }
}